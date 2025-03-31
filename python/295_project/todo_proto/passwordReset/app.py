from flask import Flask, request, render_template, redirect, session, url_for, flash
from werkzeug.security import generate_password_hash, check_password_hash
from flask_sqlalchemy import SQLAlchemy
import jwt
import datetime
import requests
from dotenv import load_dotenv
import os

app = Flask(__name__)
app.secret_key = "secretive_Key"

# SQLAlchemy Configuration
app.config["SQLALCHEMY_DATABASE_URI"] = "sqlite:///user.db"
app.config["SQLALCHEMY_TRACK_MODIFICATIONS"] = False
db = SQLAlchemy(app)

# Mailgun Configuration
load_dotenv()  # Load environment variables from .env file
MAILGUN_DOMAIN = os.getenv("MAILGUN_DOMAIN") 
MAILGUN_API_KEY = os.getenv("MAILGUN_API_KEY") 
SENDER_EMAIL = os.getenv("SENDER_EMAIL")

# User Model
class User(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    username = db.Column(db.String(50), nullable=False, unique=True)
    email = db.Column(db.String(100), nullable=False, unique=True)
    password_hash = db.Column(db.String(100), nullable=False)

    def set_password(self, password):
        self.password_hash = generate_password_hash(password)

    def check_password(self, password):
        return check_password_hash(self.password_hash, password)

# Home Route
@app.route("/")
def home():
    if "username" in session:
        return redirect(url_for("dashboard"))
    return render_template("login.html")

# Login Route
@app.route("/login", methods=["GET", "POST"])
def login():
    if request.method == "POST":
        username = request.form.get("username")
        password = request.form.get("password")
        user = User.query.filter_by(username=username).first()
        if user and user.check_password(password):
            session["username"] = username
            return redirect(url_for("dashboard"))
        else:
            flash("Invalid username or password!")
    return render_template("login.html")

# Register Route
@app.route("/register", methods=["GET", "POST"])
def register():
    if request.method == "POST":
        username = request.form.get("username")
        email = request.form.get("email")
        password = request.form.get("password")
        user_check = User.query.filter_by(username=username).first()
        email_check = User.query.filter_by(email=email).first()
        if user_check:
            flash("Username already exists!")
        elif email_check:
            flash("Email already exists!")
        else:
            new_user = User(username=username, email=email)
            new_user.set_password(password)
            db.session.add(new_user)
            db.session.commit()
            flash("Account successfully created!")
            return redirect(url_for("login"))
    return render_template("registerUser.html")

# Dashboard Route
@app.route("/dashboard")
def dashboard():
    if "username" in session:
        return render_template("dashboard.html", user={"username": session["username"]})
    return redirect(url_for("home"))

# Logout Route
@app.route("/logout")
def logout():
    session.pop("username", None)
    return redirect(url_for("home"))

# Reset Password Request Route
@app.route("/reset_request", methods=["GET", "POST"])
def reset_request():
    if request.method == "POST":
        email = request.form.get("email")
        user = User.query.filter_by(email=email).first()
        if user:
            token = jwt.encode(
                {'user_id': user.id, 'exp': datetime.datetime.utcnow() + datetime.timedelta(hours=1)},
                app.secret_key,
                algorithm="HS256"
            )
            reset_url = url_for("reset_password", token=token, _external=True)
            response = send_mailgun_email(
                recipient=email,
                subject="Password Reset Request",
                body=f"Click the link below to reset your password:\n{reset_url}"
            )
            if response.status_code == 200:
                flash("Password reset link has been sent to your email!")
            else:
                flash("Failed to send password reset email. Please try again later.")
            return redirect(url_for("login"))
        else:
            flash("Email not found!")
    return render_template("resetRequest.html")

# Reset Password Route
@app.route("/reset_password/<token>", methods=["GET", "POST"])
def reset_password(token):
    try:
        payload = jwt.decode(token, app.secret_key, algorithms=["HS256"])
        user_id = payload.get("user_id")
    except jwt.ExpiredSignatureError:
        flash("The reset link has expired!")
        return redirect(url_for("reset_request"))
    except jwt.InvalidTokenError:
        flash("Invalid reset link!")
        return redirect(url_for("reset_request"))

    user = User.query.get(user_id)
    if request.method == "POST":
        new_password = request.form.get("password")
        user.set_password(new_password)
        db.session.commit()
        flash("Your password has been reset successfully!")
        return redirect(url_for("login"))

    return render_template("resetPassword.html")

def send_mailgun_email(recipient, subject, body):
    """Send an email using Mailgun."""
    response = requests.post(
        f"https://api.mailgun.net/v3/{MAILGUN_DOMAIN}/messages",
        auth=("api", MAILGUN_API_KEY),
        data={
            "from": f"Password Reset <{SENDER_EMAIL}>",
            "to": [recipient],
            "subject": subject,
            "text": body
        }
    )
    # Log the response for debugging
    print(f"Status Code: {response.status_code}")  # Log HTTP status code
    print(f"Response Body: {response.text}")       # Log response body
    return response


if __name__ == '__main__':
    with app.app_context():
        db.create_all()
    app.run(debug=True)
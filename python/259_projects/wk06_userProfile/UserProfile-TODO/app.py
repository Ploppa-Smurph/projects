import os
from typing import Optional
from flask import Flask, flash, redirect, url_for, render_template
from flask_sqlalchemy import SQLAlchemy
from sqlalchemy.orm import Mapped, mapped_column
from sqlalchemy import String, Text
from flask_login import LoginManager, UserMixin, current_user, login_user, login_required, logout_user
from werkzeug.security import generate_password_hash, check_password_hash
from flask_wtf import FlaskForm
from wtforms import StringField, PasswordField, SubmitField
from wtforms.validators import DataRequired, EqualTo, ValidationError

# Configure the app
app = Flask(__name__)
basedir = os.path.abspath(os.path.dirname(__file__))
app.config["SECRET_KEY"] = "I really shouldn't put my secret key directly in my code"
app.config["SQLALCHEMY_DATABASE_URI"] = 'sqlite:///' + os.path.join(basedir, 'db.sqlite')

db = SQLAlchemy(app)
login = LoginManager(app)
login.login_view = 'login'  

# Models
class User(UserMixin, db.Model):
    id = db.Column(db.Integer, primary_key=True) 
    name = db.Column(db.String(150), unique=True, nullable=False)  
    profile = db.Column(db.Text, nullable=True)  
    password_hash = db.Column(db.String(128))  

    def set_password(self, password):
        self.password_hash = generate_password_hash(password)  

    def check_password(self, password):
        return check_password_hash(self.password_hash, password)  


@login.user_loader
def load_user(id):
    return User.query.get(int(id))  


# Forms
class LoginForm(FlaskForm):
    name = StringField('name', validators=[DataRequired()])
    password = PasswordField("password", validators=[DataRequired()])
    submit = SubmitField("Sign In")


class RegistrationForm(FlaskForm):
    name = StringField('name', validators=[DataRequired()])
    password = PasswordField("password", validators=[DataRequired()])
    password2 = PasswordField("re-enter password", validators=[DataRequired(), EqualTo('password')])
    submit = SubmitField("Register")

    def validate_name(self, name):
        user = User.query.filter_by(name=name.data).first()
        if user is not None:
            raise ValidationError("Please use a different name")


class ProfileUpdateForm(FlaskForm):
    profile = StringField('profile')
    submit = SubmitField("Update Profile")


# Routes
@app.route("/")
def index():
    users = User.query.all()
    return render_template('index.html', users=users)


@app.route('/logout')
def logout():
    logout_user()  
    return redirect(url_for('index'))


@app.route("/login", methods=["GET", "POST"])
def login():
    form = LoginForm()
    if form.validate_on_submit():
        user = User.query.filter_by(name=form.name.data).first()  
        if user is None or not user.check_password(form.password.data):  
            flash('Invalid username or password')  
            return redirect(url_for('login'))  
        login_user(user)  
        return redirect(url_for("profile", name=user.name))
    return render_template('login.html', form=form)


@app.route("/register", methods=["GET", "POST"])
def register():
    if current_user.is_authenticated:
        return redirect(url_for('index'))  
    
    form = RegistrationForm()
    if form.validate_on_submit():  
        user = User(name=form.name.data)  
        user.set_password(form.password.data)  
        db.session.add(user)  
        db.session.commit()
        login_user(user)  
        return redirect(url_for('profile', name=user.name))  
    return render_template("register.html", form=form)


@app.route('/profile/<name>', methods=['GET', 'POST'])
@login_required  
def profile(name):
    user = User.query.filter_by(name=name).first_or_404()
    form = None
    if current_user.name == name:
        form = ProfileUpdateForm()
        if form.validate_on_submit():
            current_user.profile = form.profile.data
            db.session.commit()
            flash('Profile Updated')
            return redirect(url_for('profile', name=current_user.name))
        form.profile.data = current_user.profile
    return render_template('profile.html', user=user, form=form)


# Start the app
if __name__ == "__main__":
    db.create_all()  
    app.run(debug=True)

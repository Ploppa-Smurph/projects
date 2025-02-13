from flask import Flask, render_template, request, redirect, url_for, flash
from email_validator import validate_email, EmailNotValidError

app = Flask(__name__)
app.secret_key = 'supersecretkey'

nav_items = [
    {"name": "Home", "url": "index"},
    {"name": "HisStory", "url": "story"},
    {"name": "Testimonials", "url": "testimonials"},
    {"name": "Buy a Jacques", "url": "buyJacques"}
]

# Route for the homepage
@app.route('/')
def index():
    return render_template('index.html', nav_items=nav_items)

# Route for the story page
@app.route('/story')
def story():
    return render_template('story.html', nav_items=nav_items)

# Route for the testimonials page
@app.route('/testimonials')
def testimonials():
    return render_template('testimonials.html', nav_items=nav_items)

# Route for the buyJacques page
@app.route('/buyJacques', methods=['GET', 'POST'])
def buyJacques():
    if request.method == 'POST':
        name = request.form['name']
        email = request.form['email']
        address = request.form['address']

        # Basic form validation
        if not name or not email or not address:
            flash('All fields are required!', 'danger')
            return redirect(url_for('buyJacques'))

        # Email validation
        try:
            validate_email(email)
        except EmailNotValidError as e:
            flash(str(e), 'danger')
            return redirect(url_for('buyJacques'))

        # If validation is successful
        flash('Order placed successfully!', 'success')
        return redirect(url_for('buyJacques'))

    return render_template('buyJacques.html', nav_items=nav_items)

if __name__ == '__main__':
    app.run(debug=True)

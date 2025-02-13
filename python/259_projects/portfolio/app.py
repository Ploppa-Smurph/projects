from flask import Flask, render_template, request, redirect, url_for, flash
from flask_wtf import CSRFProtect, FlaskForm
from email_validator import validate_email, EmailNotValidError
from wtforms import StringField, SubmitField
from wtforms.validators import DataRequired, Email, ValidationError

app = Flask(__name__)
app.secret_key = 'supersecretkey'
csrf = CSRFProtect(app)
csrf.init_app(app)

nav_items = [
    {"name": "Home", "url": "index"},
    {"name": "HisStory", "url": "story"},
    {"name": "Testimonials", "url": "testimonials"},
    {"name": "Buy a Jacques", "url": "buyJacques"}
]

class OrderForm(FlaskForm):
    name = StringField('Name', validators=[DataRequired()])
    email = StringField('Email', validators=[DataRequired(), Email()])
    address = StringField('Address', validators=[DataRequired()])
    submit = SubmitField('Submit')

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
    form = OrderForm()
    if form.validate_on_submit():
        name = form.name.data
        email = form.email.data
        address = form.address.data

        # If validation is successful
        flash('Order placed successfully!', 'success')
        return redirect(url_for('buyJacques'))

    return render_template('buyJacques.html', form=form, nav_items=nav_items)

if __name__ == '__main__':
    app.run(debug=True)

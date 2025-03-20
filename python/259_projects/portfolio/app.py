from flask import Flask, render_template, request, redirect, url_for, flash
from flask_wtf import CSRFProtect, FlaskForm
from email_validator import validate_email, EmailNotValidError
from wtforms import StringField, SubmitField
from wtforms.validators import DataRequired, Email, ValidationError
from flask_sqlalchemy import SQLAlchemy

app = Flask(__name__)
app.secret_key = 'supersecretkey'
csrf = CSRFProtect(app)
csrf.init_app(app)

app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///orders.db'
db = SQLAlchemy(app)

nav_items = [
    {"name": "Home", "url": "index"},
    {"name": "HisStory", "url": "story"},
    {"name": "Testimonials", "url": "testimonials"},
    {"name": "Buy a Jacques", "url": "buyJacques"}
]

# Create the order database
class Order(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    name = db.Column(db.String(100), nullable=False)
    email = db.Column(db.String(100), nullable=False)
    address = db.Column(db.String(200), nullable=False)
    subtotal = db.Column(db.Float, nullable=False)
    tax = db.Column(db.Float, nullable=False)
    total = db.Column(db.Float, nullable=False)    
    with app.app_context():
        db.create_all()


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

@app.route('/buyJacques', methods=['GET', 'POST'])
def buyJacques():
    form = OrderForm()
    if form.validate_on_submit():
        name = form.name.data
        email = form.email.data
        address = form.address.data

        # For simplicity, hardcoding a subtotal value
        subtotal = 50000.00  # Assume each order costs $50,000.00
        tax = round(subtotal * 0.0975, 2)  # Calculate tax (9.75%)
        total = round(subtotal + tax, 2)   # Calculate total

        # Save the order to the database
        new_order = Order(name=name, email=email, address=address, subtotal=subtotal, tax=tax, total=total)
        db.session.add(new_order)
        db.session.commit()

        flash(f'Order placed successfully! Subtotal: ${subtotal}, Tax: ${tax}, Total: ${total}', 'success')
        return redirect(url_for('buyJacques'))

        # If validation is successful
        flash('Order placed successfully!', 'success')
        return redirect(url_for('buyJacques'))

    return render_template('buyJacques.html', form=form, nav_items=nav_items)

@app.route('/orders')
def orders():
    all_orders = Order.query.all()
    return render_template('orders.html', orders=all_orders)

if __name__ == '__main__':
    app.run(debug=True)

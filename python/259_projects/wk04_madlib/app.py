from flask import Flask, render_template, request, redirect, url_for
from flask_wtf import FlaskForm
from wtforms import StringField, IntegerField, SubmitField
from wtforms.validators import DataRequired, Email, NumberRange
import email_validator

app = Flask(__name__)
app.config['SECRET_KEY'] = 'secret_key'

class MadlibForm(FlaskForm):
    name = StringField('Name', validators=[DataRequired()])
    email = StringField('Email', validators=[DataRequired(), Email()])
    noun1 = StringField('Noun 1', validators=[DataRequired()])
    noun2 = StringField('Noun 2', validators=[DataRequired()])
    adjective = StringField('Adjective', validators=[DataRequired()])
    number = IntegerField('Number', validators=[DataRequired(), NumberRange(min=0)])
    submit = SubmitField('Generate Madlib')

@app.route('/', methods=['GET', 'POST'])
def home():
    form = MadlibForm()
    madlib = None
    if form.validate_on_submit():
        name = form.name.data
        noun1 = form.noun1.data
        noun2 = form.noun2.data
        adjective = form.adjective.data
        number = form.number.data
        madlib = f"{name} went to the {noun1} to look for a {adjective} {noun2}. They found {number} of them while they where there."
        form.name.data = ""
        form.email.data = ""
        form.noun1.data = ""
        form.noun2.data = ""
        form.adjective.data = ""
        form.number.data = ""
    return render_template('index.html', form=form, madlib=madlib)

if __name__ == '__main__':
    app.run(debug=True)

from flask_wtf import FlaskForm
from wtforms import StringField, PasswordField, SubmitField, TextAreaField, FileField
from wtforms.validators import DataRequired, Email, EqualTo, Length, ValidationError
from flask_wtf.file import FileAllowed, FileRequired
from models import User

class RegistrationForm(FlaskForm):
    username = StringField('Username', validators=[DataRequired(), Length(min=2, max=64)])
    email = StringField('Email', validators=[DataRequired(), Email(), Length(max=120)])
    password = PasswordField('Password', validators=[DataRequired()])
    confirm_password = PasswordField('Confirm Password', 
                                     validators=[DataRequired(), EqualTo('password')])
    submit = SubmitField('Register')
    
    def validate_username(self, username):
        user = User.query.filter_by(username=username.data).first()
        if user:
            raise ValidationError('That username is taken. Please choose another.')
    
    def validate_email(self, email):
        user = User.query.filter_by(email=email.data).first()
        if user:
            raise ValidationError('That email is already registered.')

class LoginForm(FlaskForm):
    username = StringField('Username', validators=[DataRequired(), Length(min=2, max=64)])
    password = PasswordField('Password', validators=[DataRequired()])
    remember = SubmitField('Remember Me')  # alternatively use BooleanField if desired
    submit = SubmitField('Login')

class ArtworkUploadForm(FlaskForm):
    title = StringField('Title', validators=[DataRequired(), Length(max=140)])
    description = TextAreaField('Description')
    # You might include a category selector here in the future.
    image_file = FileField('Upload Image', validators=[
        FileRequired(), FileAllowed(['jpg', 'jpeg', 'png', 'gif'], 'Images only!')
    ])
    submit = SubmitField('Upload Artwork')

class AudioUploadForm(FlaskForm):
    title = StringField('Title', validators=[DataRequired(), Length(max=140)])
    description = TextAreaField('Description')
    audio_file = FileField('Upload Audio', validators=[
        FileRequired(), FileAllowed(['mp3', 'wav', 'ogg'], 'Audio files only!')
    ])
    submit = SubmitField('Upload Audio')

class SoundboardForm(FlaskForm):
    title = StringField('Soundboard Title', validators=[DataRequired(), Length(max=140)])
    board_data = TextAreaField('Board Configuration (JSON)', validators=[DataRequired()])  
    # In a real app you’d provide a more interactive UI than a text area.
    submit = SubmitField('Create Soundboard')
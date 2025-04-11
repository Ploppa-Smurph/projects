# models.py (excerpt)
from extensions import db, login_manager
from flask_login import UserMixin
from datetime import datetime

@login_manager.user_loader
def load_user(user_id):
    return User.query.get(int(user_id))

class User(db.Model, UserMixin):
    # ... existing fields ...
    id = db.Column(db.Integer, primary_key=True)
    username = db.Column(db.String(64), unique=True, nullable=False)
    email = db.Column(db.String(120), unique=True, nullable=False)
    password = db.Column(db.String(128), nullable=False)
    registered_on = db.Column(db.DateTime, default=datetime.utcnow)
    
    artworks = db.relationship('Artwork', backref='artist', lazy='dynamic')
    audio_works = db.relationship('AudioWork', backref='artist', lazy='dynamic')
    soundboards = db.relationship('Soundboard', backref='owner', lazy='dynamic')
    # ...

class Category(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    name = db.Column(db.String(64), unique=True, nullable=False)
    description = db.Column(db.Text)
    
    artworks = db.relationship('Artwork', backref='category', lazy='dynamic')
    audio_works = db.relationship('AudioWork', backref='category', lazy='dynamic')
    
    def __repr__(self):
        return f"<Category {self.name}>"

class Artwork(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    title = db.Column(db.String(140), nullable=False)
    image_file = db.Column(db.String(140), nullable=False)  # stored filename
    description = db.Column(db.Text)
    created_on = db.Column(db.DateTime, default=datetime.utcnow)
    
    user_id = db.Column(db.Integer, db.ForeignKey('user.id'), nullable=False)
    category_id = db.Column(db.Integer, db.ForeignKey('category.id'), nullable=True)
    
    # Relationship to access associated sounds
    sounds = db.relationship('AudioWork', backref='artwork', lazy='dynamic')
    
    def __repr__(self):
        return f"<Artwork {self.title}>"

class AudioWork(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    title = db.Column(db.String(140), nullable=False)
    audio_file = db.Column(db.String(140), nullable=False)  # stored filename
    description = db.Column(db.Text)
    created_on = db.Column(db.DateTime, default=datetime.utcnow)  # or datetime.now(timezone.utc)
    
    user_id = db.Column(db.Integer, db.ForeignKey('user.id'), nullable=False)
    category_id = db.Column(db.Integer, db.ForeignKey('category.id'), nullable=True)
    # Explicitly name the foreign key constraint here:
    artwork_id = db.Column(db.Integer, db.ForeignKey('artwork.id', name='fk_audio_work_artwork_id'), nullable=True)
    
    def __repr__(self):
        return f"<AudioWork {self.title}>"

class Soundboard(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    title = db.Column(db.String(140), nullable=False)
    board_data = db.Column(db.Text)  # JSON blob: mapping items to layout etc.
    created_on = db.Column(db.DateTime, default=datetime.utcnow)
    
    user_id = db.Column(db.Integer, db.ForeignKey('user.id'), nullable=False)
    
    def __repr__(self):
        return f"<Soundboard {self.title}>"
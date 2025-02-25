from flask_sqlalchemy import SQLAlchemy

db = SQLAlchemy()

class Publisher(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    name = db.Column(db.String(50), unique=True, nullable=False)
    games = db.relationship('Game', backref='publisher', lazy=True)

class Game(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    title = db.Column(db.String(100), unique=True, nullable=False)
    publisher_id = db.Column(db.Integer, db.ForeignKey('publisher.id'), nullable=False)

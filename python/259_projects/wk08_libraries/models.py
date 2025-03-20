from flask_sqlalchemy import SQLAlchemy

db = SQLAlchemy()

# Association table for Many-to-Many relationship
book_library = db.Table('book_library',
    db.Column('book_id', db.Integer, db.ForeignKey('book.id'), primary_key=True),
    db.Column('library_id', db.Integer, db.ForeignKey('library.id'), primary_key=True)
)

class Book(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    title = db.Column(db.String(120), nullable=False)
    author = db.Column(db.String(120), nullable=False)
    libraries = db.relationship('Library', secondary=book_library, back_populates='books')

class Library(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    name = db.Column(db.String(120), nullable=False)
    address = db.Column(db.String(200), nullable=False)
    books = db.relationship('Book', secondary=book_library, back_populates='libraries')

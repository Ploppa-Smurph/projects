from flask import Flask, redirect, url_for, render_template
from models import db, Book, Library

app = Flask(__name__)
app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///library.db'
app.config['SQLALCHEMY_TRACK_MODIFICATIONS'] = False
db.init_app(app)

@app.route('/')
def index():
    return redirect(url_for('list_books'))

@app.route('/books')
def list_books():
    books = Book.query.all()
    return render_template('books.html', books=books)

@app.route('/libraries')
def list_libraries():
    libraries = Library.query.all()
    return render_template('libraries.html', libraries=libraries)

@app.route('/books/<int:book_id>')
def book_detail(book_id):
    book = Book.query.get(book_id)
    return render_template('book_detail.html', book=book)

@app.route('/libraries/<int:library_id>')
def library_detail(library_id):
    library = Library.query.get(library_id)
    return render_template('library_detail.html', library=library)

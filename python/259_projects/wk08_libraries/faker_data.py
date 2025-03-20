from faker import Faker
from models import db, Book, Library
from app import app
import random

fake = Faker()

with app.app_context():
    db.drop_all()
    db.create_all()

    # Create Libraries
    libraries = []
    for _ in range(10):
        library = Library(name=f"{fake.last_name()} Public Library", address=fake.address())
        libraries.append(library)
        db.session.add(library)

    # Create Books
    books = []
    for _ in range(10):
        book = Book(title=fake.sentence(), author=fake.name())
        books.append(book)
        db.session.add(book)

    db.session.commit()

    # Assign Books to Libraries
    for book in books:
        for library in libraries:
            if random.choice([True, False]):
                book.libraries.append(library)
        db.session.add(book)

    db.session.commit()

from faker import Faker
from app import app, db, User

fake = Faker()

# Populate the database with fake users
def populate():
    for _ in range(200):  # Populate with 200 entries
        user = User(name=fake.name(), phone=fake.phone_number())
        db.session.add(user)
    db.session.commit()

if __name__ == "__main__":
    # Ensure the app's context is active
    with app.app_context():
        populate()
    print("Database successfully populated with fake users!")

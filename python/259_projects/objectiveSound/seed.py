# seed.py
import os
import random
from datetime import datetime
from app import app
from extensions import db, bcrypt
from models import Category, Artwork, AudioWork, User

def seed_user():
    # Create or retrieve a dummy user for filler media.
    user = User.query.filter_by(username="filler_artist").first()
    if not user:
        password = bcrypt.generate_password_hash("password").decode("utf-8")
        user = User(username="filler_artist", email="filler@example.com", password=password)
        db.session.add(user)
        db.session.commit()
    return user

def seed_categories_and_media():
    # Define our 12 categories.
    category_names = [
        "Woods", "Strings", "Metals", "Glass", "Urban", "Vintage",
        "Neon", "Abstract", "Nature", "Futuristic", "Punk", "Electro"
    ]
    user = seed_user()
    
    # Create each category if it doesn't exist.
    for name in category_names:
        cat = Category.query.filter_by(name=name).first()
        if not cat:
            cat = Category(name=name, description=f"A collection of {name} objects and sounds.")
            db.session.add(cat)
            db.session.commit()
        
        # For each category, create up to 20 artworks if less exist.
        artworks = Artwork.query.filter_by(category_id=cat.id).all()
        count_existing = len(artworks)
        for i in range(20 - count_existing):
            art_title = f"{name} Object {count_existing + i + 1}"
            # Use a placeholder image filename (e.g., "woods_1.jpg")
            image_file = f"{name.lower()}_{count_existing + i + 1}.jpg"
            art = Artwork(
                title=art_title,
                description=f"An object imbued with {name.lower()} character.",
                image_file=image_file,
                user_id=user.id,
                category_id=cat.id,
                created_on=datetime.utcnow()
            )
            db.session.add(art)
            db.session.commit()
            
            # Create between 6 and 10 sounds for this artwork.
            num_sounds = random.randint(6, 10)
            for j in range(num_sounds):
                audio_title = f"{art_title} Sound {j + 1}"
                audio_file = f"{name.lower()}_{count_existing + i + 1}_{j + 1}.mp3"
                audio = AudioWork(
                    title=audio_title,
                    description=f"Premade tone for {art_title}.",
                    audio_file=audio_file,
                    user_id=user.id,
                    category_id=cat.id,
                    artwork_id=art.id,
                    created_on=datetime.utcnow()
                )
                db.session.add(audio)
            db.session.commit()

if __name__ == '__main__':
    with app.app_context():
        print("Seeding dummy data...")
        seed_categories_and_media()
        print("Seeding complete!")
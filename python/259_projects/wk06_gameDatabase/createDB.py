from app import app, db
from models import Publisher, Game

with app.app_context():
    db.create_all()
    
    # Add publishers
    pub1 = Publisher(name='Electronic Arts')
    pub2 = Publisher(name='Sierra')
    pub3 = Publisher(name='Nintendo')

    db.session.add_all([pub1, pub2, pub3])
    db.session.commit()

    # Add games
    game1 = Game(title='FIFA 24', publisher_id=pub1.id)
    game2 = Game(title='The Sims 4', publisher_id=pub1.id)
    game3 = Game(title='Leisure Suit Larry', publisher_id=pub2.id)
    game4 = Game(title="King's Quest", publisher_id=pub2.id)
    game5 = Game(title='Super Mario 64', publisher_id=pub3.id)
    game6 = Game(title='The Legend of Zelda', publisher_id=pub3.id)

    db.session.add_all([game1, game2, game3, game4, game5, game6])
    db.session.commit()

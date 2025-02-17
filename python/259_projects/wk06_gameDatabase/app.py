from flask import Flask, render_template
from config import Config
from models import db, Publisher, Game

app = Flask(__name__)
app.config.from_object(Config)
db.init_app(app)

@app.route('/')
def index():
    publishers = Publisher.query.all()
    return render_template('index.html', publishers=publishers)

@app.route('/publisher/<int:publisher_id>')
def publisher(publisher_id):
    publisher = Publisher.query.get_or_404(publisher_id)
    return render_template('publisher.html', publisher=publisher)

if __name__ == '__main__':
    app.run(debug=True)

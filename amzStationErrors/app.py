import os
from dotenv import load_dotenv
from flask import Flask, render_template
from flask_caching import Cache

# Load environment variables from the .env file
load_dotenv()

# Create the Flask application instance
app = Flask(__name__)

# Configure Flask-Caching to use Redis.
app.config['CACHE_TYPE'] = 'redis'
# Heroku typically provides a REDIS_URL environment variable; fallback to local Redis if not set.
app.config['CACHE_REDIS_URL'] = os.getenv('REDIS_URL', 'redis://localhost:6379/0')
app.config['CACHE_DEFAULT_TIMEOUT'] = 3600  # Cache timeout in seconds (e.g., 1 hour)

# Initialize Cache
cache = Cache(app)

# Import and register blueprints
from blueprints.reports.routes import reports_bp
from blueprints.drive.routes import drive_bp

app.register_blueprint(reports_bp, url_prefix='/reports')
app.register_blueprint(drive_bp, url_prefix='/drive')

# Home route
@app.route('/')
def home():
    return render_template('home.html')

# About route
@app.route('/about')
def about():
    return render_template('about.html')

# Contact route.
@app.route('/contact')
def contact():
    return render_template('contact.html')

if __name__ == '__main__':
    app.run(debug=True)
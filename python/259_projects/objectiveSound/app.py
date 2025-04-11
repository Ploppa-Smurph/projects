# app.py
import os
from flask import Flask, render_template
from config import Config
from extensions import db, migrate, login_manager, bcrypt

def create_app(config_class=Config):
    app = Flask(__name__)
    app.config.from_object(config_class)
    
    # Initialize extensions with the app
    db.init_app(app)
    migrate.init_app(app, db)
    login_manager.init_app(app)
    bcrypt.init_app(app)
    
    # Register Blueprints - adjust these imports as per your project structure.
    from blueprints.auth import auth_bp
    app.register_blueprint(auth_bp, url_prefix='/auth')
    
    from blueprints.uploads import uploads_bp
    app.register_blueprint(uploads_bp, url_prefix='/uploads')
    
    from blueprints.categories import categories_bp
    app.register_blueprint(categories_bp, url_prefix='/categories')
    
    from blueprints.soundboard import soundboard_bp
    app.register_blueprint(soundboard_bp, url_prefix='/soundboard')
    
    # Define a simple landing page route
    @app.route('/')
    def index():
        return render_template('index.html', title="ObjectiveSound")
    
    # Custom error handler for 404 errors
    @app.errorhandler(404)
    def not_found_error(error):
        return render_template('404.html', title="Page Not Found"), 404
    
    return app

# Create the global app instance so that Flask CLI (and migrations) can find it.
app = create_app()

if __name__ == '__main__':
    app.run(debug=True)
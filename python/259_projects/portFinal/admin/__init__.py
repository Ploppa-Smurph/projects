# admin/__init__.py
from flask import Blueprint

admin_bp = Blueprint('admin', __name__)

# Import the routes so that they are attached to admin_bp
from . import routes
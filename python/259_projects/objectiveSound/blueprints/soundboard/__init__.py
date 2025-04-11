from flask import Blueprint

soundboard_bp = Blueprint('soundboard', __name__)

from . import routes
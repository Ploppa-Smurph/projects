# api/blueprint.py

from flask import Blueprint, jsonify, abort, current_app
from flask_httpauth import HTTPBasicAuth, HTTPTokenAuth
from itsdangerous import URLSafeTimedSerializer as Serializer, BadSignature, SignatureExpired
from models import birds

# Create a blueprint for version 1 of the API
apiv1 = Blueprint('apiv1', __name__, url_prefix='/api/v1')

# Initialize the authentication objects
login_auth = HTTPBasicAuth()
token_auth = HTTPTokenAuth(scheme='Bearer')

# ---- HTTP Basic Authentication (for token generation) ----
@login_auth.verify_password
def verify_password(username, password):
    # Hardcode credentials: username 'carl' and password 'password'
    if username == 'carl' and password == 'password':
        return username
    return None

@login_auth.error_handler
def basic_auth_error():
    return jsonify({'error': 'Unauthorized access. Invalid username or password.'}), 401

# ---- Token Authentication (for protected endpoints) ----
@token_auth.verify_token
def verify_token(token):
    s = Serializer(current_app.config['SECRET_KEY'], salt="auth-token")
    try:
        # Enforce a max_age of 3600 seconds (1 hour)
        data = s.loads(token, max_age=3600)
    except SignatureExpired:
        # Valid token, but expired
        return None
    except BadSignature:
        # Invalid token
        return None
    return data.get('username')

@token_auth.error_handler
def token_auth_error():
    return jsonify({'error': 'Invalid or expired token.'}), 401

# ---- API Endpoints ----

# /api/v1/token: Generate a token after basic authentication
@apiv1.route('/token', methods=['GET'])
@login_auth.login_required
def get_token():
    s = Serializer(current_app.config['SECRET_KEY'], salt="auth-token")
    token = s.dumps({'username': login_auth.current_user()})
    # In newer versions, s.dumps returns a string directly.
    return jsonify({'token': token})

# /api/v1/birds: Return the full list of birds along with the requesting user's name.
@apiv1.route('/birds', methods=['GET'])
@token_auth.login_required
def get_birds():
    birds_list = [bird.to_json() for bird in birds]
    return jsonify({
        'user': token_auth.current_user(),
        'birds': birds_list
    })

# /api/v1/birds/<id>: Return details for a single bird identified by its index.
@apiv1.route('/birds/<int:bird_id>', methods=['GET'])
@token_auth.login_required
def get_bird(bird_id):
    if bird_id < 0 or bird_id >= len(birds):
        abort(404, description='Bird not found')
    bird = birds[bird_id].to_json()
    return jsonify({
        'user': token_auth.current_user(),
        'bird': bird
    })

# Additional error handler for the blueprint (optional here, since we have one in app.py)
@apiv1.errorhandler(404)
def not_found(e):
    return jsonify({
        'error': 'Not Found',
        'message': str(e)
    }), 404
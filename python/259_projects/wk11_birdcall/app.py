# app.py
from flask import Flask, jsonify
from api.blueprint import apiv1

app = Flask(__name__)
app.config['SECRET_KEY'] = 'your_secret_key_here'  # Change this to a secure value for production

# Register the API blueprint with URL prefix /api/v1
app.register_blueprint(apiv1)

# Global 404 error handler to return JSON instead of HTML
@app.errorhandler(404)
def not_found_error(e):
    return jsonify({
        'error': 'Not Found',
        'message': str(e)
    }), 404

if __name__ == '__main__':
    app.run(debug=True)
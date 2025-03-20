from flask import Flask, render_template
import logging

app = Flask(__name__)

# Configure logging to file
logger = logging.getLogger(__name__)
logger.setLevel(logging.ERROR)
file_handler = logging.FileHandler('error.log')
file_handler.setLevel(logging.ERROR)
formatter = logging.Formatter('[%(asctime)s] %(levelname)s in %(module)s: %(message)s')
file_handler.setFormatter(formatter)
logger.addHandler(file_handler)

# Index route: renders the index page
@app.route('/')
def index():
    return render_template('index.html')

# Error-generation route: deliberately divides by zero to cause an exception
@app.route('/cause-error')
def cause_error():
    try:
        result = 1 / 0
    # This will throw a ZeroDivisionError
    except ZeroDivisionError as e:
        logger.exception('Attempted to divide by zero')
        return render_template('error_500.html'), 500
    return f"The result is {result}"

# Custom 404 error page
@app.errorhandler(404)
def not_found_error(error):
    return render_template('error_404.html'), 404

# Custom 500 error page
@app.errorhandler(500)
def internal_error(error):
    # Log the error details to file
    logger.exception('Server Error: %s', error)
    return render_template('error_500.html'), 500

if __name__ == '__main__':
    app.run(debug=True)

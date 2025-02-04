# Import 'Flask' class from 'flask' module
from flask import Flask

# create Flask class instance. Variable "__name__" determines root app path
app = Flask(__name__)

# @app.route decorator is used to bind a URL to "show_car_info" function. The route captures the name color and car parameters from the URL
@app.route('/name/<name>/color/<color>/car/<car>')
def show_car_info(name, color, car):
    # show_car_info function takes captured parameters and returns string "<name> drives a <color> <car>."
    return f"{name} drives a {color} {car}."

# development server is started by calling run() method on app object 
if __name__ == '__main__':
    app.run(debug=True)
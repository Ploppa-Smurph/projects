from flask import Flask, render_template

app = Flask(__name__)

@app.route('/')
def index():
    return render_template('index.html')

@app.route('/hobby01')
def hobby01():
    return render_template('hobby01.html')

@app.route('/hobby02')
def hobby02():
    return render_template('hobby02.html')

@app.route('/hobby03')
def hobby03():
    return render_template('hobby03.html')

@app.route('/foods')
def foods():
    foods = ['Cheese Burgers', 'Pie (Savory Empanadas or Sweet Dessert Pies)', 'Pizza (Some consider it a pie, also)', 'Tacos', 'Jalapeno Cornbread', 'Cheeses']
    return render_template('foods.html', foods=foods)

if __name__ == '__main__':
    app.run(debug=True)
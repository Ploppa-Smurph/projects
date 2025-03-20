from flask import Flask, request, make_response, render_template
from flask_cors import CORS

app = Flask(__name__, template_folder='templates')

@app.route('/', methods=['GET', 'POST'])
def index():

    if request.method == 'GET':
        pass

    if request.method == 'POST':
       name = request.form.get('name')
       post = request.form.get('post')
       create_post(name, post)

    posts = get_posts()

    return render_template('index.html', posts=posts)

    
if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5000, debug=True)
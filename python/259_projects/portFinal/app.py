import os
from flask import Flask, render_template, redirect, url_for, flash, request, abort
from config import Config
from extensions import db, migrate, login_manager, bcrypt
from flask_login import login_required, current_user, login_user, logout_user
import logging
from logging.handlers import RotatingFileHandler

def create_app(config_class=Config):
    app = Flask(__name__)
    app.config.from_object(config_class)
    
    # Initialize extensions with app
    db.init_app(app)
    migrate.init_app(app, db)
    login_manager.init_app(app)
    bcrypt.init_app(app)
    
    # Register Blueprints
    from admin import admin_bp  # Import from the package root.
    app.register_blueprint(admin_bp, url_prefix='/admin')
    
    from api.routes import api_bp
    app.register_blueprint(api_bp, url_prefix='/api')
    
    # Global Error Handler for 404 (WK7)
    @app.errorhandler(404)
    def not_found_error(error):
        return render_template('404.html', title='404 Not Found'), 404

    # Configure Logging to a Text File (WK7)
    if not app.debug:
        if not os.path.exists('logs'):
            os.mkdir('logs')
        file_handler = RotatingFileHandler('logs/app.log', maxBytes=10240, backupCount=10)
        file_handler.setFormatter(logging.Formatter(
            '%(asctime)s %(levelname)s: %(message)s [in %(pathname)s:%(lineno)d]'))
        file_handler.setLevel(logging.INFO)
        app.logger.addHandler(file_handler)
        
        app.logger.setLevel(logging.INFO)
        app.logger.info('Walley Web World startup')
    
    return app

app = create_app()

# Import forms and models after app creation to avoid circular imports
from forms import LoginForm, RegistrationForm, ProjectForm, RequestResetForm, ResetPasswordForm
from models import User, Project

# Home Page, Login, Logout, Registration, etc.
@app.route('/')
def index():
    return render_template('index.html', title='Home')

@app.route('/project/<int:project_id>')
def project_detail(project_id):
    project = Project.query.get_or_404(project_id)
    return render_template('project_detail.html', title=project.title, project=project)

@app.route('/login', methods=['GET', 'POST'])
def login():
    if current_user.is_authenticated:
        return redirect(url_for('index'))
    form = LoginForm()
    if form.validate_on_submit():
        user = User.query.filter_by(name=form.username.data).first()
        if user and bcrypt.check_password_hash(user.password, form.password.data):
            login_user(user, remember=form.remember.data)
            flash('Logged in successfully.', 'success')
            return redirect(url_for('index'))
        else:
            flash('Invalid username or password', 'danger')
    return render_template('login.html', title='Sign In', form=form)

@app.route('/logout')
def logout():
    logout_user()
    return redirect(url_for('index'))

@app.route('/register', methods=['GET', 'POST'])
def register():
    if current_user.is_authenticated:
        return redirect(url_for('index'))
    form = RegistrationForm()
    if form.validate_on_submit():
        hashed_pw = bcrypt.generate_password_hash(form.password.data).decode('utf-8')
        user = User(name=form.name.data, email=form.email.data, password=hashed_pw)
        db.session.add(user)
        db.session.commit()
        flash('Congratulations, you are now a registered user!', 'success')
        return redirect(url_for('login'))
    return render_template('register.html', title='Register', form=form)

@app.route('/submit_project', methods=['GET', 'POST'])
@login_required
def submit_project():
    form = ProjectForm()
    if form.validate_on_submit():
        project = Project(title=form.title.data, description=form.description.data, user_id=current_user.id)
        db.session.add(project)
        db.session.commit()
        flash('Your project has been submitted!', 'success')
        return redirect(url_for('projects'))
    return render_template('submit_project.html', title='Submit Project', form=form)

@app.route('/projects')
def projects():
    page = request.args.get('page', 1, type=int)
    projects_page = Project.query.paginate(page=page, per_page=5)
    return render_template('projects.html', title='Projects', projects=projects_page)

@app.route('/reset_password', methods=['GET', 'POST'])
def reset_password_request():
    if current_user.is_authenticated:
        return redirect(url_for('index'))
    form = RequestResetForm()
    if form.validate_on_submit():
        user = User.query.filter_by(email=form.email.data).first()
        if user:
            token = user.get_reset_token()
            flash('A password reset token has been generated. (For testing purposes, it is shown below)', 'info')
            flash(f'Token: {token}', 'info')
        else:
            flash('No account associated with this email.', 'warning')
        return redirect(url_for('login'))
    return render_template('password_reset.html', title='Reset Password', form=form)

@app.route('/reset_password/<token>', methods=['GET', 'POST'])
def reset_password(token):
    if current_user.is_authenticated:
        return redirect(url_for('index'))
    user = User.verify_reset_token(token)
    if not user:
        flash('That is an invalid or expired token', 'warning')
        return redirect(url_for('reset_password_request'))
    form = ResetPasswordForm()
    if form.validate_on_submit():
        hashed_pw = bcrypt.generate_password_hash(form.password.data).decode('utf-8')
        user.password = hashed_pw
        db.session.commit()
        flash('Your password has been updated! You can now log in.', 'success')
        return redirect(url_for('login'))
    return render_template('password_reset.html', title='Reset Password', form=form)

if __name__ == '__main__':
    app.run(debug=True)
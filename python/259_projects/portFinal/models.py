# models.py
from extensions import db, login_manager
from flask_login import UserMixin
from itsdangerous import URLSafeTimedSerializer as Serializer, BadSignature, SignatureExpired
from flask import current_app

@login_manager.user_loader
def load_user(user_id):
    return User.query.get(int(user_id))

# Association table for many-to-many: Projects and Tags (WK8)
project_tags = db.Table('project_tags',
    db.Column('project_id', db.Integer, db.ForeignKey('project.id'), primary_key=True),
    db.Column('tag_id', db.Integer, db.ForeignKey('tag.id'), primary_key=True)
)

class User(db.Model, UserMixin):
    id = db.Column(db.Integer, primary_key=True)
    name = db.Column(db.String(64))
    email = db.Column(db.String(120), unique=True, index=True)
    password = db.Column(db.String(128))
    projects = db.relationship('Project', backref='author', lazy=True)

    def get_reset_token(self, expires_sec=1800):
        """Generate a password reset token."""
        s = Serializer(current_app.config['SECRET_KEY'])
        # The salt "password-reset" is arbitrary but must be consistent.
        return s.dumps({'user_id': self.id}, salt='password-reset')

    @staticmethod
    def verify_reset_token(token, expires_sec=1800):
        """Verify the password reset token."""
        s = Serializer(current_app.config['SECRET_KEY'])
        try:
            data = s.loads(token, salt='password-reset', max_age=expires_sec)
            user_id = data.get('user_id')
        except (SignatureExpired, BadSignature):
            return None
        return User.query.get(user_id)

    def __repr__(self):
        return f'<User {self.name}>'

class Project(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    title = db.Column(db.String(140))
    description = db.Column(db.Text)
    user_id = db.Column(db.Integer, db.ForeignKey('user.id'), nullable=False)
    tags = db.relationship('Tag', secondary=project_tags, backref=db.backref('projects', lazy='dynamic'))

    def __repr__(self):
        return f'<Project {self.title}>'

class Tag(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    name = db.Column(db.String(50), unique=True)

    def __repr__(self):
        return f'<Tag {self.name}>'
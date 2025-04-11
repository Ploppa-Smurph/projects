from flask import render_template, redirect, url_for, flash, request
from flask_login import login_required, current_user
from blueprints.soundboard import soundboard_bp
from forms import SoundboardForm
from models import Soundboard
from extensions import db

@soundboard_bp.route('/', methods=['GET'])
@login_required
def soundboard_list():
    # List the current user's soundboards
    boards = Soundboard.query.filter_by(user_id=current_user.id).order_by(Soundboard.created_on.desc()).all()
    return render_template('soundboard/soundboard.html', title="My Soundboards", boards=boards)

@soundboard_bp.route('/create', methods=['GET', 'POST'])
@login_required
def create_soundboard():
    form = SoundboardForm()
    if form.validate_on_submit():
        board = Soundboard(title=form.title.data,
                           board_data=form.board_data.data,
                           user_id=current_user.id)
        db.session.add(board)
        db.session.commit()
        flash('Soundboard created successfully!', 'success')
        return redirect(url_for('soundboard.soundboard_list'))
    return render_template('soundboard/create_soundboard.html', title="Create Soundboard", form=form)
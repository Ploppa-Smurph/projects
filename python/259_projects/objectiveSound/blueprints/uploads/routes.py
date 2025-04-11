import os
from flask import render_template, current_app, flash, redirect, url_for
from flask_login import login_required, current_user
from werkzeug.utils import secure_filename
from blueprints.uploads import uploads_bp
from forms import ArtworkUploadForm, AudioUploadForm
from models import Artwork, AudioWork
from extensions import db

@uploads_bp.route('/upload', methods=['GET', 'POST'])
@login_required
def upload():
    # We can show both forms on the same page (or separate them later)
    artwork_form = ArtworkUploadForm(prefix='art')
    audio_form = AudioUploadForm(prefix='audio')
    
    if artwork_form.validate_on_submit() and 'art-image_file' in artwork_form.image_file.name:
        # Process artwork upload
        f = artwork_form.image_file.data
        filename = secure_filename(f.filename)
        image_path = os.path.join(current_app.config['UPLOAD_FOLDER'], 'images', filename)
        f.save(image_path)
        artwork = Artwork(title=artwork_form.title.data,
                          description=artwork_form.description.data,
                          image_file=filename,
                          user_id=current_user.id)
        db.session.add(artwork)
        db.session.commit()
        flash('Artwork uploaded successfully!', 'success')
        return redirect(url_for('uploads.upload'))
    
    # Process audio upload
    if audio_form.validate_on_submit() and 'audio-audio_file' in audio_form.audio_file.name:
        f = audio_form.audio_file.data
        filename = secure_filename(f.filename)
        audio_path = os.path.join(current_app.config['UPLOAD_FOLDER'], 'audio', filename)
        f.save(audio_path)
        audio_work = AudioWork(title=audio_form.title.data,
                               description=audio_form.description.data,
                               audio_file=filename,
                               user_id=current_user.id)
        db.session.add(audio_work)
        db.session.commit()
        flash('Audio uploaded successfully!', 'success')
        return redirect(url_for('uploads.upload'))
    
    return render_template('uploads/upload.html', title="Upload Media",
                           artwork_form=artwork_form, audio_form=audio_form)
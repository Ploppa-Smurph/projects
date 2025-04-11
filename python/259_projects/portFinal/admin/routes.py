# admin/routes.py
from flask import render_template, redirect, url_for, flash
from flask_login import current_user, login_required
from . import admin_bp  # This gets the blueprint defined in __init__.py
from models import Project
from extensions import db
from forms import ProjectForm

# Admin dashboard to list the current user's projects
@admin_bp.route('/')
@login_required
def dashboard():
    projects = Project.query.filter_by(user_id=current_user.id).all()
    return render_template('admin/dashboard.html', title='Admin Dashboard', projects=projects)

# Route to edit a project
@admin_bp.route('/edit_project/<int:project_id>', methods=['GET', 'POST'])
@login_required
def edit_project(project_id):
    project = Project.query.get_or_404(project_id)
    if project.author != current_user:
        flash('You are not authorized to edit this project.', 'danger')
        return redirect(url_for('admin.dashboard'))
    form = ProjectForm(obj=project)
    if form.validate_on_submit():
        project.title = form.title.data
        project.description = form.description.data
        db.session.commit()
        flash('Project updated successfully!', 'success')
        return redirect(url_for('admin.dashboard'))
    return render_template('admin/edit_project.html', title='Edit Project', form=form, project=project)
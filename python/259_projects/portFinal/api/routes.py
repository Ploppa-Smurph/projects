from flask import Blueprint, jsonify, abort
from models import Project

api_bp = Blueprint('api', __name__)

@api_bp.route('/projects', methods=['GET'])
def get_projects():
    projects = Project.query.all()
    projects_list = [{
        'id': project.id,
        'title': project.title,
        'description': project.description,
        'author': project.author.name
    } for project in projects]
    return jsonify({'projects': projects_list})

@api_bp.route('/projects/<int:project_id>', methods=['GET'])
def get_project(project_id):
    project = Project.query.get_or_404(project_id)
    project_data = {
        'id': project.id,
        'title': project.title,
        'description': project.description,
        'author': project.author.name
    }
    return jsonify(project_data)
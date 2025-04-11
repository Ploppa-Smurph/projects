from flask import render_template, abort
from blueprints.categories import categories_bp
from models import Category, Artwork, AudioWork

@categories_bp.route('/overview')
def overview():
    categories = Category.query.all()
    return render_template('categories/overview.html', title="Categories Overview", categories=categories)

@categories_bp.route('/<string:category_name>')
def category_page(category_name):
    category = Category.query.filter_by(name=category_name).first()
    if not category:
        abort(404)
    # Retrieve artworks and audio works for this category
    artworks = category.artworks.order_by(Artwork.created_on.desc()).all()
    audio_works = category.audio_works.order_by(AudioWork.created_on.desc()).all()
    return render_template('categories/category.html', title=category.name,
                           category=category, artworks=artworks, audio_works=audio_works)
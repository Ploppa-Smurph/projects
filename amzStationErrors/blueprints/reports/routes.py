from flask import Blueprint, render_template, request, current_app
from datetime import datetime
from itertools import groupby
from .models import Report
from blueprints.drive.utils import get_drive_images
import os

# Define the Blueprint
reports_bp = Blueprint("reports", __name__)


@reports_bp.route("/daily_reports")
def daily_reports():
    day_filter = request.args.get("day", None)
    today_date = datetime.now().date()

    # Google Drive Reports
    folder_id = os.getenv("GOOGLE_DRIVE_FOLDER_ID")
    if not folder_id:
        raise Exception("Google Drive folder ID not set in environment variables.")

    drive_images = get_drive_images(folder_id)
    drive_reports = []

    for image in drive_images:
        dt = None
        # Prefer EXIF metadata date if available
        if image.get("exifDateTime"):
            date_str = image.get("exifDateTime")
            try:
                # EXIF format example: "2022:05:15 14:30:00"
                dt = datetime.strptime(date_str, "%Y:%m:%d %H:%M:%S")
            except ValueError as e:
                print(f"Error parsing EXIF date for image {image.get('id')}: {e}")
        else:
            # Fall back on Google Drive's createdTime if available
            date_str = image.get("createdTime")
            if date_str:
                try:
                    dt = datetime.strptime(date_str, "%Y-%m-%dT%H:%M:%S.%fZ")
                except (ValueError, TypeError) as e:
                    print(f"Error parsing createdTime for image {image.get('id')}: {e}")

        # If neither worked, default to the current time
        if dt is None:
            dt = datetime.now()

        image_id = image["id"].strip()
        drive_reports.append(
            Report(
                title=image["name"].strip(),
                description="Google Drive Image",
                file_id=image_id,  # Save the file_id for proxy routing.
                image_filename=f"https://drive.google.com/uc?export=view&id={image_id}",
                date=dt,
                thumbnail=image.get("thumbnailLink")
                or f"https://drive.google.com/uc?export=view&id={image_id}",
        )
    )

    # Combine all reports
    all_reports = drive_reports

    # Optional Filtering
    if day_filter == "today":
        filtered_reports = [r for r in all_reports if r.date.date() == today_date]
    elif day_filter == "this_week":
        filtered_reports = [
            r for r in all_reports if (today_date - r.date.date()).days < 7
        ]
    elif day_filter == "archive":
        filtered_reports = [
            r for r in all_reports if (today_date - r.date.date()).days >= 7
        ]
    else:
        filtered_reports = all_reports

    # Group reports by day (newest first) and sort by time (earliest to latest within each day)
    filtered_reports.sort(key=lambda r: r.date)  # Sort by time (ascending)
    filtered_reports.sort(
        key=lambda r: r.date.date(), reverse=True
    )  # Then sort by date (newest first)

    grouped_reports = {}
    for group_date, items in groupby(filtered_reports, key=lambda r: r.date.date()):
        grouped_reports[group_date] = list(items)

    return render_template("daily_reports.html", grouped_reports=grouped_reports)


@reports_bp.route("/submit_error", methods=["GET", "POST"])
def submit_error():
    if request.method == "POST":
        # Get submitted form data
        title = request.form.get("title")
        description = request.form.get("description")
        date_str = request.form.get("date")
        error_image = request.files.get("error_image")

        # Process the date string (assumes 'YYYY-MM-DD')
        try:
            date_obj = datetime.strptime(date_str, "%Y-%m-%d")
        except Exception:
            date_obj = datetime.now()

        # Save the uploaded file into a static folder (e.g., static/uploads)
        uploads_dir = os.path.join(current_app.root_path, "static", "uploads")
        os.makedirs(uploads_dir, exist_ok=True)
        filename = None

        if error_image:
            filename = error_image.filename
            file_path = os.path.join(uploads_dir, filename)
            error_image.save(file_path)

        return "Error report submitted successfully!"

    # Render the submit error form for GET requests
    return render_template("submit_error.html")

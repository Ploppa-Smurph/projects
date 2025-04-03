# In blueprints/drive/routes.py
from flask import Blueprint, Response
import os
import io
from google.oauth2 import service_account
from googleapiclient.discovery import build
from blueprints.drive.utils import download_file  # ensure this is correctly imported

drive_bp = Blueprint("drive", __name__)

@drive_bp.route("/image/<file_id>")
def drive_image(file_id):
    service_account_file = os.environ.get("GOOGLE_SERVICE_ACCOUNT_FILE")
    if not service_account_file:
        return "Service account file not set", 500

    # Define scope and build the Google Drive service instance
    SCOPES = ['https://www.googleapis.com/auth/drive.readonly']
    credentials = service_account.Credentials.from_service_account_file(
        service_account_file, scopes=SCOPES
    )
    service = build('drive', 'v3', credentials=credentials)

    try:
        image_bytes = download_file(service, file_id)
    except Exception as e:
        return f"Error fetching image: {e}", 500

    # Adjust mimetype accordingly
    return Response(image_bytes, mimetype="image/jpeg")
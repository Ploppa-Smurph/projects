import os
import io
from google.oauth2 import service_account
from googleapiclient.discovery import build
from googleapiclient.http import MediaIoBaseDownload
from PIL import Image, ExifTags

def extract_datetime_from_image(image_bytes):
    """
    Given image bytes, extract the DateTimeOriginal from the image's EXIF data.
    Returns None if the metadata is missing or on error.
    """
    try:
        image = Image.open(io.BytesIO(image_bytes))
        exif_data = image._getexif()
        if not exif_data:
            return None
        for tag, value in exif_data.items():
            tag_name = ExifTags.TAGS.get(tag, tag)
            if tag_name == 'DateTimeOriginal':
                return value
    except Exception as e:
        print(f"Error extracting EXIF data: {e}")
    return None

def download_file(service, file_id):
    """
    Downloads the file content from Google Drive given its file_id.
    Returns the file content as bytes.
    """
    request = service.files().get_media(fileId=file_id)
    file_stream = io.BytesIO()
    downloader = MediaIoBaseDownload(file_stream, request)
    done = False
    while not done:
        status, done = downloader.next_chunk()
        # Optionally, you might log the progress here.
    file_stream.seek(0)
    return file_stream.read()

def get_drive_images(folder_id):
    """
    Retrieves image files from the specified Google Drive folder.
    For each image, it downloads the file and extracts the original
    DateTime (EXIF DateTimeOriginal) from the image's metadata.
    Returns a list of dictionaries for each image.
    """
    # Get the service account file path from the environment.
    service_account_file = os.environ.get("GOOGLE_SERVICE_ACCOUNT_FILE")
    if not service_account_file:
        raise Exception("Google service account file not set in .env")

    # The scope for readonly access to Google Drive
    SCOPES = ['https://www.googleapis.com/auth/drive.readonly']

    # Build credentials and the Drive API service.
    credentials = service_account.Credentials.from_service_account_file(
        service_account_file, scopes=SCOPES)
    service = build('drive', 'v3', credentials=credentials)

    # Query to find image files in the specified folder.
    query = f"'{folder_id}' in parents and mimeType contains 'image/' and trashed = false"
    images = []
    page_token = None

    while True:
        results = service.files().list(
            q=query,
            pageSize=20,
            fields="nextPageToken, files(id, name, thumbnailLink)",
            pageToken=page_token
        ).execute()

        for file in results.get('files', []):
            file_id = file.get('id')
            try:
                # Download the image file from Drive
                file_bytes = download_file(service, file_id)
                # Extract EXIF DateTimeOriginal metadata
                exif_datetime = extract_datetime_from_image(file_bytes)
            except Exception as e:
                print(f"Error processing file {file_id}: {e}")
                exif_datetime = None

            # IMPORTANT: Provide a full-size link by constructing the URL.
            image_info = {
                'id': file_id,
                'name': file.get('name'),
                'thumbnailLink': file.get('thumbnailLink'),
                'image_filename': f"https://drive.google.com/uc?export=view&id={file_id}",
                'exifDateTime': exif_datetime
            }
            images.append(image_info)

        page_token = results.get('nextPageToken')
        if not page_token:
            break

    return images

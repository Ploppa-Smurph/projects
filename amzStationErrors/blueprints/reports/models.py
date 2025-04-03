from datetime import datetime

class Report:
    def __init__(self, title, description, image_filename, date, thumbnail, file_id):
        self.title = title
        self.description = description
        self.image_filename = image_filename
        self.date = date
        self.thumbnail = thumbnail
        self.file_id = file_id
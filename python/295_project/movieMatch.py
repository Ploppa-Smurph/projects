class MovieMatch:
    def __init__(self):
        self.my_list = []
        self.wife_list = []

    def add_to_my_list(self, item):
        self.my_list.append(item)

    def add_to_wife_list(self, item):
        self.wife_list.append(item)

    def compare_lists(self):
        matched_items = set(self.my_list) & set(self.wife_list)
        return matched_items

def main():
    app = MovieMatch()

    # Example usage:
    app.add_to_my_list('Inception')
    app.add_to_my_list('The Matrix')
    app.add_to_wife_list('Inception')
    app.add_to_wife_list('Titanic')

    matched_items = app.compare_lists()
    if matched_items:
        print("Movies/Shows to watch together:")
        for item in matched_items:
            print(item)
    else:
        print("No matched movies/shows found.")

if __name__ == "__main__":
    main()

# Import the necessary libraries
import random
from collections import defaultdict

# Define a function to print out the number of rooms and cats
def print_info(rooms, cats):
    print(f"The house has {rooms} rooms.")
    print(f"There are {cats} cats in the house.")

# Define a function to guess which room each cat is in
def guess_room(rooms, cats, cats_rooms, labels):
    # Loop through all the rooms and try to find a room that has enough cats in it
    for i in range(len(labels)):
        if labels[i] not in cats_rooms.keys():
            cats_rooms[labels[i]] = set()
        room = random.choice(labels)
        if len(room) < 2:
            continue
        # If the room has enough cats, print out that room and break out of the loop
        elif len(cats_rooms[room]) < cats:
            print(f"I think your cat is in {room}.")
            break
        # Add the current cat to the list of cats in this room
        else:
            cats_rooms[room].add(labels[i])
    # If none of the rooms have enough cats, print out a random room
    else:
        print(f"I think your cat is in {random.choice(labels)}.")

# Define a function to learn which room each cat likes the most
def learn_rooms(rooms, cats, cats_rooms):
    for i in range(len(cats)):
        room = random.choice(rooms)
        if len(room) < 2:
            continue
        # If the room has enough cats, print out that room and break out of the loop
        elif len(cats_rooms[room]) < cats:
            continue
        else:
            print(f"{labels[i]} likes {room}.")
    return cats_rooms

# Define the main function to run the program
def main():
    # Ask the user for the number of rooms in their house and print out some information
    rooms = int(input("How many rooms does your house have? "))
    print_info(rooms, 0)

    # Ask the user to label the rooms in their house
    labels = [f"Room {i}" for i in range(1, rooms+1)]
    for i in range(len(labels)):
        labels[i] = input(f"Label room {i+1}: ")
    print_info(rooms, len(cats))

    # Ask the user to input the number of cats that live in their house and print out some information
    cats = int(input("How many cats do you have? "))
    print_info(rooms, cats)

    # Ask the user to name each cat and add them to a dictionary
    cats_rooms = defaultdict(set)
    for i in range(len(labels)):
        labels[i] = input(f"Name your {i+1}st cat: ")
        cats_rooms[labels[i]].add(labels[i])

    # Guess which room each cat is in and learn over time which room each cat likes the most
    guess_room(rooms, cats, cats_rooms, labels)
    learn_rooms(rooms, cats, cats_rooms)

if __name__ == "__main__":
    main()

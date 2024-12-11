package basicPortfolio.catfinder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RoomService {
    private HidingSpots hidingSpots;
    private Scanner scanner;

    public RoomService(HidingSpots hidingSpots, Scanner scanner) {
        this.hidingSpots = hidingSpots;
        this.scanner = scanner;
    }

    // Method to read room data from user input
    public void inputRoomData() throws CustomException {
        System.out.print("Enter the number of rooms: ");
        int numRooms = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (numRooms <= 0) {
            throw new CustomException("The number of rooms must be positive.");
        }

        for (int i = 0; i < numRooms; i++) {
            System.out.print("Enter the name of room " + (i + 1) + ": ");
            String roomName = scanner.nextLine();
            List<String> spots = hidingSpots.getHidingSpots(roomName);
            if (spots != null) {
                continue;
            }
            System.out.println("Adding custom hiding spots for room: " + roomName);
            List<String> customSpots = new ArrayList<>();
            System.out.println("Enter hiding spots (type 'done' to finish):");
            while (true) {
                String spot = scanner.nextLine();
                if (spot.equalsIgnoreCase("done")) {
                    break;
                }
                customSpots.add(spot);
            }
            hidingSpots.addCustomRoom(roomName, customSpots);
        }
    }

    // Overloaded method to read room data from file
    public void inputRoomData(Scanner fileScanner) {
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine().trim();
            if (!line.isEmpty()) {
                String[] parts = line.split(", ");
                String room = parts[0];
                List<String> spots = Arrays.asList(parts).subList(1, parts.length);
                hidingSpots.addCustomRoom(room, spots);
            }
        }
    }

    public void modifyRooms() {
        System.out.println("Would you like to add, edit, or remove a room? (add/edit/remove)");
        String choice = scanner.nextLine();
        switch (choice.toLowerCase()) {
            case "add":
                try {
                    inputRoomData();
                } catch (CustomException e) {
                    System.err.println(e.getMessage());
                }
                break;
            case "edit":
                editRoomData();
                break;
            case "remove":
                removeRoomData();
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private void editRoomData() {
        System.out.print("Enter the name of the room you want to edit: ");
        String oldName = scanner.nextLine();
        if (hidingSpots.getRooms().containsKey(oldName)) {
            System.out.print("Enter the new name for the room: ");
            String newName = scanner.nextLine();
            List<String> spots = hidingSpots.getRooms().remove(oldName);
            hidingSpots.getRooms().put(newName, spots);
        } else {
            System.out.println("Room not found.");
        }
    }

    private void removeRoomData() {
        System.out.print("Enter the name of the room you want to remove: ");
        String name = scanner.nextLine();
        if (hidingSpots.getRooms().containsKey(name)) {
            hidingSpots.getRooms().remove(name);
        } else {
            System.out.println("Room not found.");
        }
    }
}

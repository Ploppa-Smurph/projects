package basicPortfolio.catfinder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoomService {
    private HidingSpots hidingSpots;
    private Scanner scanner;

    public RoomService(HidingSpots hidingSpots, Scanner scanner) {
        this.hidingSpots = hidingSpots;
        this.scanner = scanner;
    }

    public void inputRoomData() {
        System.out.print("Enter the number of rooms: ");
        int numRooms = scanner.nextInt();
        scanner.nextLine(); // consume newline

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

    public void modifyRooms() {
        System.out.println("Would you like to add, edit, or remove a room? (add/edit/remove)");
        String choice = scanner.nextLine();
        switch (choice.toLowerCase()) {
            case "add":
                inputRoomData();
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
        hidingSpots.getRooms().remove(name);
    }
}

package basicPortfolio.catfinder;

import java.io.*;
import java.util.*;

public class CatFinder {
    private static List<Cat> cats;
    private static HidingSpots hidingSpots;
    private static Scanner scanner;
    private static CatService catService;
    private static RoomService roomService;

    public void run() {
        scanner = new Scanner(System.in);
        hidingSpots = new HidingSpots();
        cats = new ArrayList<>();
        catService = new CatService(cats, scanner);
        roomService = new RoomService(hidingSpots, scanner);

        System.out.println("Do you want to load the previous session? (yes/no)");
        String loadOption = scanner.nextLine();

        if (loadOption.equalsIgnoreCase("yes")) {
            loadFromFile();
        } else {
            catService.inputCatData();
            roomService.inputRoomData();
        }

        guessCatLocations();

        while (true) {
            System.out.println("Would you like to add, edit, or remove cats or rooms and run again? (yes/no)");
            String modifyOption = scanner.nextLine();
            if (modifyOption.equalsIgnoreCase("no")) {
                saveToFile();
                break;
            } else {
                modifyData();
                guessCatLocations();
            }
        }
    }

    private static void guessCatLocations() {
        Random random = new Random();
        List<String> rooms = new ArrayList<>(hidingSpots.getRooms().keySet());

        for (Cat cat : cats) {
            String room = rooms.get(random.nextInt(rooms.size()));
            String hidingSpot = hidingSpots.getRandomHidingSpot(room);
            System.out.println("Cat " + cat.getName() + " is napping in the " + room + ", " + hidingSpot);
        }
    }

    private static void modifyData() {
        System.out.println("Would you like to modify cats or rooms? (cats/rooms)");
        String modifyChoice = scanner.nextLine();
        if (modifyChoice.equalsIgnoreCase("cats")) {
            catService.modifyCats();
        } else if (modifyChoice.equalsIgnoreCase("rooms")) {
            roomService.modifyRooms();
        }
    }

    private static void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("catsAndRooms.txt"))) {
            oos.writeObject(cats);
            oos.writeObject(hidingSpots);
            System.out.println("Session saved.");
        } catch (IOException e) {
            System.err.println("Error saving session: " + e.getMessage());
        }
    }

    private static void loadFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("catsAndRooms.txt"))) {
            cats = (List<Cat>) ois.readObject();
            hidingSpots = (HidingSpots) ois.readObject();
            // Re-initialize services with loaded data
            catService = new CatService(cats, scanner);
            roomService = new RoomService(hidingSpots, scanner);
            System.out.println("Session loaded.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading session: " + e.getMessage());
            catService.inputCatData();
            roomService.inputRoomData();
        }
    }
}

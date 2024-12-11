package basicPortfolio.catfinder;

import java.io.*;
import java.util.*;

public class CatFinder {
    private static List<Cat> cats;
    private static HidingSpots hidingSpots;
    private static Scanner scanner;
    private static CatService catService;
    private static RoomService roomService;

    public static void main(String[] args) {
        CatFinder catFinder = new CatFinder();
        catFinder.run();
    }

    public void run() {
        scanner = new Scanner(System.in);
        hidingSpots = new HidingSpots();
        cats = new ArrayList<>();
        catService = new CatService(cats, scanner);
        roomService = new RoomService(hidingSpots, scanner);
        System.out.println("Ch05: Read Data from File Using Scanner \n");

        System.out.println("\nDo you want to load the previous session? (yes/no)");
        String loadOption = scanner.nextLine();

        if (loadOption.equalsIgnoreCase("yes")) {
            try {
                loadFromFile();
            } catch (FileNotFoundException e) {
                System.err.println("File not found: " + e.getMessage());
                // Optionally, load default data
                inputCatAndRoomData();
            }
        } else {
            inputCatAndRoomData();
        }

        guessCatLocations();

        while (true) {
            System.out.println("Would you like to add, edit, or remove cats or rooms and run again? (yes/no)");
            String modifyOption = scanner.nextLine();
            if (modifyOption.equalsIgnoreCase("no")) {
                try {
                    saveToFile();
                } catch (IOException e) {
                    System.err.println("Error saving session: " + e.getMessage());
                }
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

    private static void saveToFile() throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter("catsAndRooms.txt"))) {
            writer.println("cats:");
            for (Cat cat : cats) {
                writer.println(cat.getName());
            }
            writer.println("rooms:");
            for (Map.Entry<String, List<String>> entry : hidingSpots.getRooms().entrySet()) {
                writer.print(entry.getKey());
                for (String spot : entry.getValue()) {
                    writer.print(", " + spot);
                }
                writer.println();
            }
            System.out.println("Session saved.");
        }
    }

    private static void loadFromFile() throws FileNotFoundException {
        File file = new File("catsAndRooms.txt");
        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine().trim();
                if (line.equals("cats:")) {
                    catService.inputCatData(fileScanner);
                } else if (line.equals("rooms:")) {
                    roomService.inputRoomData(fileScanner);
                }
            }
            System.out.println("Session loaded.");
        }
    }

    private static void inputCatAndRoomData() {
        try {
            catService.inputCatData();
            roomService.inputRoomData();
        } catch (CustomException e) {
            System.err.println(e.getMessage());
        }
    }
}

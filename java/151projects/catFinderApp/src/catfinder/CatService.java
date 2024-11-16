package catfinder;

import java.util.List;
import java.util.Scanner;

public class CatService {
    private List<Cat> cats;
    private Scanner scanner;

    public CatService(List<Cat> cats, Scanner scanner) {
        this.cats = cats;
        this.scanner = scanner;
    }

    public void inputCatData() {
        System.out.print("Enter the number of cats: ");
        int numCats = scanner.nextInt();
        scanner.nextLine(); // consume newline

        for (int i = 0; i < numCats; i++) {
            System.out.print("Enter the name of cat " + (i + 1) + ": ");
            String catName = scanner.nextLine();
            cats.add(new Cat(catName));
        }
    }

    public void modifyCats() {
        System.out.println("Would you like to add, edit, or remove a cat? (add/edit/remove)");
        String choice = scanner.nextLine();
        switch (choice.toLowerCase()) {
            case "add":
                inputCatData();
                break;
            case "edit":
                editCatData();
                break;
            case "remove":
                removeCatData();
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private void editCatData() {
        System.out.print("Enter the name of the cat you want to edit: ");
        String oldName = scanner.nextLine();
        for (Cat cat : cats) {
            if (cat.getName().equalsIgnoreCase(oldName)) {
                System.out.print("Enter the new name for the cat: ");
                cat.setName(scanner.nextLine());
                return;
            }
        }
        System.out.println("Cat not found.");
    }

    private void removeCatData() {
        System.out.print("Enter the name of the cat you want to remove: ");
        String name = scanner.nextLine();
        cats.removeIf(cat -> cat.getName().equalsIgnoreCase(name));
    }
}

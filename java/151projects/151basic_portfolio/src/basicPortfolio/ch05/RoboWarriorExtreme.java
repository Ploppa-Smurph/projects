package basicPortfolio.ch05;

import java.util.Scanner;

public class RoboWarriorExtreme implements RoboWarriorType {
    private RoboWarrior chosenWarrior;

    @Override
    public void chooseWarrior(String type) {
        boolean validType = false;

        // Check if the chosen type is valid
        for (String warrior : WARRIOR_TYPES) {
            if (warrior.equalsIgnoreCase(type)) {
                validType = true;
                chosenWarrior = new RoboWarrior(type);
                break;
            }
        }

        // Set description if valid, else prompt for valid type
        if (validType) {
            System.out.println("You have chosen the path of the " + chosenWarrior.getType() + ", a " + chosenWarrior.getDescription());
        } else {
            System.out.println("Invalid warrior type. Choose from: " + String.join(", ", WARRIOR_TYPES));
        }
    }

    public void start() {
        System.out.println("Ch06 & Ch07: Proper use of Switch statement, Create useful interface and at least 1 class that implements that interface, Create useful class with 1 overloaded method \n");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose your RoboWarrior Class ('Ninja', 'Priest', 'Berserker', or 'Mystic'): ");
        String select = scanner.nextLine();
        chooseWarrior(select);

        if (chosenWarrior != null) {
            System.out.println("\nYou will now join the battle as a " + chosenWarrior.getType());

            // Demo actions including all overloaded method actions
            chosenWarrior.move();
            chosenWarrior.attack();
            chosenWarrior.attack("punch");
            chosenWarrior.attack("kick");
            chosenWarrior.attack("laser");
            chosenWarrior.attack("plasmasword");
            chosenWarrior.defend();
        }
    }

    // Main method for testing the functionality
    public static void main(String[] args) {
        RoboWarriorExtreme warrior = new RoboWarriorExtreme();
        warrior.start();
    }
}

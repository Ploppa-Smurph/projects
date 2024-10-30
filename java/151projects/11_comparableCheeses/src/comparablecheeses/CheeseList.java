package comparablecheeses;

import java.util.ArrayList;

public class CheeseList {

    // Private ArrayList to store Cheese objects
    private ArrayList<Cheese> cheeses;

    // Constructor to initialize the ArrayList
    public CheeseList() {
        cheeses = new ArrayList<>();
    }

    // Method to add a Cheese object to the ArrayList
    public void addCheese(Cheese cheese) {
        cheeses.add(cheese);
    }

    // Method to print details of all cheeses in the ArrayList
    public void printCheeses() {
        for (Cheese cheese : cheeses) {
            System.out.println(cheese);
        }
    }

    // Method to sort the ArrayList using selection sort
    public void selectionSort() {
        for (int i = 0; i < cheeses.size() - 1; i++) {
            int minIndex = i;

            // Assume the min is the first element
            for (int j = i + 1; j < cheeses.size(); j++) {

                // Compare current element with assumed min
                if (cheeses.get(j).compareTo(cheeses.get(minIndex)) < 0) {

                    // Update minIndex if smaller element is encountered
                    minIndex = j;
                }
            }

            // Swap found min element with first element
            Cheese temp = cheeses.get(i);
            cheeses.set(i, cheeses.get(minIndex));
            cheeses.set(minIndex, temp);
        }
    }
}
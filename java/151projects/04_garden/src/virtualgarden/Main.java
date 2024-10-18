package virtualgarden;

// Main.java - The main class to create and interact with VirtualGarden
public class Main {
    public static void main(String[] args) {

        // Create a new VirtualGarden object with the name "My Garden"
        VirtualGarden myGarden = new VirtualGarden("My Garden");

        // Plant seeds
        myGarden.plantSeed();
        myGarden.plantSeed();
        System.out.println("Seeds: " + myGarden.getSeeds());  // print Seeds: 2

        // Water the plants (convert seeds to plants)
        myGarden.water();
        System.out.println("Plants: " + myGarden.getPlants());  // print Plants: 2

        // Harvest and reset plant count
        int harvestedPlants = myGarden.harvest();
        System.out.println("Harvested plants: " + harvestedPlants);  // print Harvested plants: 2

        // Change the season to spring
        myGarden.setSeason("Spring");
        System.out.println("Current season: " + myGarden.getSeason());  // print Current season: Spring
    }
}
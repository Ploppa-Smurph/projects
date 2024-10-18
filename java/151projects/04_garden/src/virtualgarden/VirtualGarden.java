package virtualgarden;

// VirtualGarden.java - The custom class representing a virtual garden
class VirtualGarden {
    private String name;
    private int seeds = 0;
    private int plants = 0;
    private String season = "Winter";

    // Constructor to initialize the garden with a name
    public VirtualGarden(String name) {
        this.name = name;
    }

    // Method to plant seeds
    public void plantSeed() {
        seeds++;
    }

    // Method to water the plants (convert seeds to plants)
    public void water() {
        if (seeds > 0) {
            plants += seeds;
            seeds = 0;
        }
    }

    // Method to harvest and reset plant count
    public int harvest() {
        int harvested = plants;
        plants = 0;
        return harvested;
    }

    // Getter for the number of plants
    public int getPlants() {
        return plants;
    }

    // Getter for the number of seeds
    public int getSeeds() {
        return seeds;
    }

    // Setter to change the season
    public void setSeason(String newSeason) {
        this.season = newSeason;
    }

    // Getter for the current season
    public String getSeason() {
        return season;
    }
}
package comparablecheeses;

public class Cheese implements Comparable<Cheese> {

    // Private instance variables for cheese name, stinkiness, and flavor
    private String name;
    private int stinkiness;
    private int flavor;

    // Constructor to initialize the name, stinkiness, and flavor of the cheese
    public Cheese(String name, int stinkiness, int flavor) {
        this.name = name;

        // Ensure stinkiness is between 0 and 10
        this.stinkiness = Math.max(0, Math.min(10, stinkiness));
        // Ensure flavor is between 0 and 10
        this.flavor = Math.max(0, Math.min(10, flavor));
    }

    // Implementation of the compareTo method for the Comparable interface
    @Override public int compareTo(Cheese other) {

        // Calculate the combined score for this cheese and the other cheese
        int thisScore = this.stinkiness + this.flavor;
        int otherScore = other.stinkiness + other.flavor;

        // Compare the scores and return the difference
        return thisScore - otherScore;
    }

    // Override the toString method to provide a string representation of the cheese
    @Override public String toString() {
        return name + "'s stinkiness is " + stinkiness + ", with a flavor score of " + flavor + ". The total score for this cheese is " + (stinkiness + flavor);
    }
}
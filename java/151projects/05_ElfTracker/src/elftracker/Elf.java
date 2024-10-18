package elftracker;

class Elf {
    private String name;
    private int height;

    // Constructor for Elf class, initializing name and height
    public Elf(String name, int height) {
        this.name = name;

        // Validate height
        if (height < 1) {
            this.height = 1;
        } else if (height > 10) {
            this.height = 10;
        } else {
            this.height = height;
        }
    }

    // Override toString method to provide a string representation of the Elf object
    @Override
    public String toString() {
        return name + " is a " + height + " inch tall elf.";
    }
}
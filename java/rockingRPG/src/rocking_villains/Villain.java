package rocking_villains;

import rocking_races.Race;

public class Villain {
    private String name;
    private Race race;
    private VillainClass villainClass;

    public Villain(String name, Race race, VillainClass villainClass) {
        this.name = name;
        this.race = race;
        this.villainClass = villainClass;
    }

    public String getName() {
        return name;
    }

    public Race getRace() {
        return race;
    }

    public VillainClass getVillainClass() {
        return villainClass;
    }

    public void displayInfo() {
        System.out.println("Villain: " + name + ", Race: " + race + ", Class: " + villainClass);
    }
}
package rocking_hero;

import rocking_classes.HeroClass;
import rocking_races.Race;

// Define the Hero class
public class Hero {
    private String name;
    private Race race;
    private HeroClass heroClass;
    private int level;
    private int experience;
    private int health;
    private int magic;
    private int wealth;

    // Constructor
    public Hero(String name, Race race, HeroClass heroClass) {
        this.name = name;
        this.race = race;
        this.heroClass = heroClass;
        this.level = 1;
        this.experience = 0;
        this.health = 15;
        this.magic = 5;
        this.wealth = 0;
    }

    // Display hero information
    public void displayInfo() {
        System.out.println("Hero: " + name);
        System.out.println("Race: " + race);
        System.out.println("Class: " + heroClass);
        System.out.println("Level: " + level);
        System.out.println("Experience: " + experience);
        System.out.println("Health: " + health);
        System.out.println("Magic: " + magic);
        System.out.println("Wealth: " + wealth);
    }
}

package rocking_hero;

import rocking_classes.HeroClass;
import rocking_races.Race;

// Define the Hero class
import rocking_classes.HeroClass;
import rocking_races.Race;

public class Hero {
    private String name;
    private Race race;
    private HeroClass heroClass;
    private int health;
    private int maxHealth;
    private int defense;
    private int attack;
    private int speed;
    private int intelligence;
    private boolean incapacitated;

    public Hero(String name, Race race, HeroClass heroClass) {
        this.name = name;
        this.race = race;
        this.heroClass = heroClass;
        this.maxHealth = 100; // Example starting health
        this.health = maxHealth;
        this.defense = 10; // Example starting defense
        this.attack = 15; // Example starting attack
        this.speed = 10; // Example starting speed
        this.intelligence = 10; // Example starting intelligence
        this.incapacitated = false;
    }

    public String getName() {
        return name;
    }

    public Race getRace() {
        return race;
    }

    public HeroClass getHeroClass() {
        return heroClass;
    }

    public void displayInfo() {
        System.out.println("Hero: " + name + ", Race: " + race + ", Class: " + heroClass);
        System.out.println("Health: " + health + "/" + maxHealth);
        System.out.println("Defense: " + defense);
        System.out.println("Attack: " + attack);
        System.out.println("Speed: " + speed);
        System.out.println("Intelligence: " + intelligence);
    }

    public int getHealth() {
        return health;
    }

    public void restoreHealth(int amount) {
        health = Math.min(maxHealth, health + amount);
        System.out.println(name + " restored " + amount + " health.");
    }

    public void increaseDefense(int amount) {
        defense += amount;
        System.out.println(name + "'s defense increased by " + amount + ".");
    }

    public void increaseAttack(int amount) {
        attack += amount;
        System.out.println(name + "'s attack increased by " + amount + ".");
    }

    public void increaseSpeed(int amount) {
        speed += amount;
        System.out.println(name + "'s speed increased by " + amount + ".");
    }

    public void increaseIntelligence(int amount) {
        intelligence += amount;
        System.out.println(name + "'s intelligence increased by " + amount + ".");
    }

    public boolean isIncapacitated() {
        return incapacitated;
    }

    public void takeDamage(int amount) {
        health -= amount;
        System.out.println(name + " took " + amount + " damage.");
        if (health <= 0) {
            health = maxHealth / 2;
            incapacitated = true;
            System.out.println(name + " has been incapacitated and wakes up with " + health + " health.");
        }
    }

    public int getDefense() {
        return defense;
    }

    public int getAttack() {
        return attack;
    }
}
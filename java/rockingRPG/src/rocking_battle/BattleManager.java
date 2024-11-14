package rocking_battle;

import rocking_exceptions.InCombatException;
import rocking_hero.Hero;
import rocking_villains.Villain;

import java.util.Random;
import java.util.Scanner;

public class BattleManager {
    private int heroHealth;
    private Hero hero;
    private Villain villain;

    public BattleManager(Hero hero, Villain villain, int heroHealth) {
        this.hero = hero;
        this.villain = villain;
        this.heroHealth = heroHealth;
    }

    public int startBattle(Scanner scanner) {
        Random random = new Random();
        int villainHealth = 50; // Example health value

        while (heroHealth > 0 && villainHealth > 0) {
            System.out.println("Choose your action: (attack, defend, flee)");
            String action = scanner.nextLine();
            try {
                if (action.equalsIgnoreCase("status")) {
                    throw new InCombatException("Cannot check status during combat!");
                }
                switch (action.toLowerCase()) {
                    case "attack": // Hero attacks
                        int attackDamage = random.nextInt(20) + 10; // Damage calculation
                        villainHealth -= attackDamage;
                        System.out.println("You attacked the villain and dealt " + attackDamage + " damage. Villain health: " + villainHealth);
                        break;
                    case "defend": // Hero defends
                        System.out.println("You defend yourself, reducing incoming damage.");
                        break;
                    case "flee": // Hero attempts to flee
                        System.out.println("You attempt to flee.");
                        int fleeDamage = random.nextInt(10) + 5; // flee damage
                        heroHealth -= fleeDamage;
                        System.out.println("The villain attacks as you flee and deals " + fleeDamage + " damage. Your health: " + heroHealth);
                        return heroHealth; // Returning the current hero health
                    default:
                        System.out.println("Invalid action. Try again.");
                        continue;
                }

                // Villain attacks
                if (villainHealth > 0) {
                    int villainDamage = random.nextInt(15) + 5; // damage calculation
                    heroHealth -= villainDamage;
                    System.out.println("The villain attacks and deals " + villainDamage + " damage. Your health: " + heroHealth);
                }

                // Check if the hero or villain is defeated
                if (heroHealth <= 0) {
                    System.out.println("You have been incapacitated. You wake up with half health.");
                    heroHealth = 50; // Half of initial health
                } else if (villainHealth <= 0) {
                    System.out.println("You defeated the villain! You collect items from the fallen enemy.");
                    // Collect items from the fallen enemy here
                    break;
                }
            } catch (InCombatException e) {
                System.out.println(e.getMessage());
                // Re-ask for the user's action
                System.out.println("Choose your action: (attack, defend, flee)");
            }
        }

        return heroHealth; // Returning the updated hero health
    }
}

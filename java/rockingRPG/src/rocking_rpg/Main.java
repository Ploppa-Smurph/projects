package rocking_rpg;

import rocking_classes.HeroClass;
import rocking_hero.Hero;
import rocking_races.Race;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a hero
        System.out.print("Enter hero name: ");
        String heroName = scanner.nextLine();
        System.out.println("Choose a race (HUMONID, SYNTHZ, VEGLING, LIZARFOK, CRYOBORG):");
        String raceInput = scanner.nextLine();
        Race heroRace = Race.valueOf(raceInput.toUpperCase());
        System.out.println("Choose a class (MOUTH, SIX_STRING_SAMURAI, BASSZERKER, KEYCUSSION, BANGADON):");
        String classInput = scanner.nextLine();
        HeroClass heroClass = HeroClass.valueOf(classInput.toUpperCase());

        Hero hero = new Hero(heroName, heroRace, heroClass);
        System.out.println("\nHero created!");
        hero.displayInfo();

        // Your game logic goes here!

        scanner.close();
    }
}
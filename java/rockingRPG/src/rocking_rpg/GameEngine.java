package rocking_rpg;

import rocking_classes.HeroClass;
import rocking_hero.Hero;
import rocking_places.RockingMap;
import rocking_races.Race;
import rocking_villains.RockingVillains;
import rocking_exceptions.InCombatException;
import rocking_adventures.QuestManager;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameEngine {
    private static int playerX;
    private static int playerY;
    private static int heroHealth;
    private static List<String> statusEffects;
    private static Hero hero;
    private static RockingMap map;
    private static RockingVillains villains;
    private static rocking_rpg.InventoryManager inventoryManager;
    private static QuestManager questManager;

    public static void startNewGame(Scanner scanner) {
        System.out.print("Enter hero name: ");
        String heroName = scanner.nextLine();
        System.out.println("Choose a race (HUMONID, SYNTHZ, VEGLING, LIZARFOK, CRYOBORG):");
        String raceInput = scanner.nextLine();
        Race heroRace = Race.valueOf(raceInput.toUpperCase());
        System.out.println("Choose a class (MOUTH, SIX_STRING_SAMURAI, BASSZERKER, KEYCUSSION, BANGADON):");
        String classInput = scanner.nextLine();
        HeroClass heroClass = HeroClass.valueOf(classInput.toUpperCase());
        hero = new Hero(heroName, heroRace, heroClass);
        System.out.println("\nHero created!");
        hero.displayInfo();

        // Initialize map, player position, health, and inventory
        int mapSize = 10;
        map = new RockingMap(mapSize);
        villains = new RockingVillains();
        playerX = 0;
        playerY = 0;
        heroHealth = 100; // Initial health
        statusEffects = new ArrayList<>();
        inventoryManager = new rocking_rpg.InventoryManager();
        questManager = new QuestManager();

        // Display the map
        System.out.println("\nGenerated Map:");
        map.displayMap();
    }

    public static void saveGame() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("savedGame.dat"))) {
            oos.writeInt(playerX);
            oos.writeInt(playerY);
            oos.writeInt(heroHealth);
            oos.writeObject(inventoryManager);
            oos.writeObject(statusEffects);
            oos.writeObject(questManager); // Save NPCs

            // Save hero details
            oos.writeObject(hero.getName());
            oos.writeObject(hero.getRace());
            oos.writeObject(hero.getHeroClass());
            System.out.println("Game saved successfully!");
        } catch (IOException e) {
            System.err.println("Error saving game: " + e.getMessage());
        }
    }

    public static void loadGame(Scanner scanner) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("savedGame.dat"))) {
            playerX = ois.readInt();
            playerY = ois.readInt();
            heroHealth = ois.readInt();
            inventoryManager = (rocking_rpg.InventoryManager) ois.readObject();
            statusEffects = (List<String>) ois.readObject();
            questManager = (QuestManager) ois.readObject(); // Load NPCs

            // Load hero details
            String heroName = (String) ois.readObject();
            Race heroRace = (Race) ois.readObject();
            HeroClass heroClass = (HeroClass) ois.readObject();
            hero = new Hero(heroName, heroRace, heroClass);

            // Initialize map and villains
            map = new RockingMap(10); // Assuming the map size is fixed for simplicity
            villains = new RockingVillains();
            System.out.println("Game loaded successfully!");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading game: " + e.getMessage());
            System.out.println("Starting a new game instead.");
            startNewGame(scanner);
        }
    }

    public static void displayStatus() throws InCombatException {
        if (Main.inCombat) {
            throw new InCombatException("Cannot check status during a battle! Continue fighting!");
        }
        System.out.println("Hero Status:");
        hero.displayInfo();
        System.out.println("Health: " + heroHealth);
        System.out.println("Inventory: ");
        inventoryManager.displayInventory();
        System.out.println("Status Effects: " + statusEffects);
        System.out.println("Quests:");
        questManager.displayQuests();
    }

    public static void displayMapWithPosition() {
        map.displayMapWithPosition(playerX, playerY);
        questManager.checkQuestCompletion(playerX, playerY); // Check if any quests are completed at the current position
    }

    public static int getPlayerX() {
        return playerX;
    }

    public static void setPlayerX(int x) {
        playerX = x;
    }

    public static int getPlayerY() {
        return playerY;
    }

    public static void setPlayerY(int y) {
        playerY = y;
    }

    public static int getHeroHealth() {
        return heroHealth;
    }

    public static void setHeroHealth(int health) {
        heroHealth = health;
    }

    public static RockingMap getMap() {
        return map;
    }

    public static RockingVillains getVillains() {
        return villains;
    }

    public static Hero getHero() {
        return hero;
    }

    public static rocking_rpg.InventoryManager getInventoryManager() {
        return inventoryManager;
    }

    public static QuestManager getQuestManager() {
        return questManager;
    }
}

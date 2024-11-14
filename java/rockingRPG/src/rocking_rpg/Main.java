package rocking_rpg;

import rocking_places.Terrain;
import rocking_exceptions.InCombatException;

import java.util.Scanner;

public class Main {
    public static boolean inCombat = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Rocking RPG!");
        System.out.print("Do you want to load a saved game? (yes/no): ");
        String loadGame = scanner.nextLine();
        if (loadGame.equalsIgnoreCase("yes")) {
            GameEngine.loadGame(scanner);
        } else {
            GameEngine.startNewGame(scanner);
        }

        // Player movement
        while (true) {
            System.out.println("Enter move (up, down, left, right), 'status' to check status, 'map' to check map, or 'quit' to exit: ");
            String move = scanner.nextLine();
            if (move.equalsIgnoreCase("quit")) {
                GameEngine.saveGame();
                System.out.println("Game saved. Exiting...");
                break;
            }
            if (move.equalsIgnoreCase("status")) {
                try {
                    GameEngine.displayStatus();
                } catch (InCombatException e) {
                    System.out.println(e.getMessage());
                    continue;
                }
                continue;
            }
            if (move.equalsIgnoreCase("map")) {
                GameEngine.displayMapWithPosition();
                continue;
            }
            switch (move.toLowerCase()) {
                case "up":
                    if (GameEngine.getPlayerX() > 0) GameEngine.setPlayerX(GameEngine.getPlayerX() - 1);
                    break;
                case "down":
                    if (GameEngine.getPlayerX() < GameEngine.getMap().getSize() - 1)
                        GameEngine.setPlayerX(GameEngine.getPlayerX() + 1);
                    break;
                case "left":
                    if (GameEngine.getPlayerY() > 0) GameEngine.setPlayerY(GameEngine.getPlayerY() - 1);
                    break;
                case "right":
                    if (GameEngine.getPlayerY() < GameEngine.getMap().getSize() - 1)
                        GameEngine.setPlayerY(GameEngine.getPlayerY() + 1);
                    break;
                default:
                    System.out.println("Invalid move. Try again.");
                    continue;
            }

            // Display current location and interaction
            Terrain currentTerrain = GameEngine.getMap().getTerrain(GameEngine.getPlayerX(), GameEngine.getPlayerY());
            System.out.println("You are now at (" + GameEngine.getPlayerX() + ", " + GameEngine.getPlayerY() + ") - " + currentTerrain);
            InteractionHandler.handleInteraction(currentTerrain, scanner);
        }
        scanner.close();
    }
}

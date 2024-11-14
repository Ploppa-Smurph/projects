package rocking_rpg;

import rocking_battle.BattleManager;
import rocking_items.*;
import rocking_npc.NPC;
import rocking_places.Terrain;
import rocking_villains.Villain;

import java.util.Random;
import java.util.Scanner;

public class InteractionHandler {
    public static void handleInteraction(Terrain terrain, Scanner scanner) {
        switch (terrain) {
            case TREASURE:
                System.out.println("You found a treasure!");
                Item treasureItem = new TreasureItem("Golden Coin", "Gold", "Rare", ItemEffectType.INCREASE_DEFENSE, 10);
                GameEngine.getInventoryManager().addItem(treasureItem);
                break;
            case ITEM:
                Item foundItem = getRandomItem();
                System.out.println("You found an item: " + foundItem.getName());
                GameEngine.getInventoryManager().addItem(foundItem);
                break;
            case NPC:
                NPC npc = getRandomNPC();
                System.out.println("You encountered " + npc.getName() + " (" + npc.getOccupation() + "). They have a quest for you:");
                System.out.println(npc.getQuestDescription());
                System.out.print("Do you accept the quest? (yes/no): ");
                String acceptQuest = scanner.nextLine();
                if (acceptQuest.equalsIgnoreCase("yes")) {
                    GameEngine.getQuestManager().addNPC(npc);
                    System.out.println("Quest accepted!");
                } else {
                    System.out.println("Quest declined.");
                }
                break;
            case VILLAIN:
                Villain villain = GameEngine.getVillains().getRandomVillain();
                System.out.println("A villain appears!");
                villain.displayInfo();
                Main.inCombat = true;
                BattleManager battleManager = new BattleManager(GameEngine.getHero(), villain, GameEngine.getHeroHealth());
                GameEngine.setHeroHealth(battleManager.startBattle(scanner));
                Main.inCombat = false;
                break;
            default:
                System.out.println("Nothing special here.");
                break;
        }
    }

    private static Item getRandomItem() {
        Random random = new Random();
        int itemType = random.nextInt(5); // Assuming 5 different item types for simplicity

        switch (itemType) {
            case 0:
                return new HealingHerb("Green Healing Herb", "Green", "Common", 20);
            case 1:
                return new ChickenFeather("Chicken Feather", "White", "Uncommon");
            case 2:
                return new RockCandy("Rock Candy", "Gray", "Uncommon");
            case 3:
                return new CaveCheese("Cave Cheese", "Yellow", "Rare");
            case 4:
                return new ChiliPepper("Chili Pepper", "Red", "Rare");
            default:
                return new HealingHerb("Green Healing Herb", "Green", "Common", 20); // Default item
        }
    }

    private static NPC getRandomNPC() {
        Random random = new Random();
        int npcType = random.nextInt(2); // Assuming 2 different NPC types for simplicity

        switch (npcType) {
            case 0:
                return new NPC("Eldon the Wise", "Sage", "Find the Ancient Tome in the library at (5,5)", 5, 5);
            case 1:
                return new NPC("Jora the Brave", "Warrior", "Defeat the Lead Villain Zarnak at (7,8)", 7, 8);
            default:
                return new NPC("Eldon the Wise", "Sage", "Find the Ancient Tome in the library at (5,5)", 5, 5); // Default NPC
        }
    }
}

package rocking_rpg;

import rocking_hero.Hero;
import rocking_items.Item;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class InventoryManager implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Item> inventory;

    public InventoryManager() {
        this.inventory = new ArrayList<>();
    }

    public void addItem(Item item) {
        inventory.add(item);
        System.out.println(item.getName() + " added to inventory.");
    }

    public void useItem(String itemName, Hero hero) {
        for (Item item : inventory) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                item.applyEffect(hero);
                System.out.println("Used " + item.getName());
                inventory.remove(item);
                break;
            }
        }
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void displayInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            for (Item item : inventory) {
                System.out.println(item.getName() + " - " + item.getColor() + " - " + item.getEffectType() + " - " + item.getRarity());
            }
        }
    }
}

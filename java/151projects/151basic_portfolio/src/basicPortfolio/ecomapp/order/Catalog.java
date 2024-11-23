package basicPortfolio.ecomapp.order;

import java.util.HashMap;
import java.util.Map;

public class Catalog {
    private Map<Integer, Item> items;

    public Catalog() {
        items = new HashMap<>();
        items.put(1, new Item("Pulp Planet T-Shirt", 19.99));
        items.put(2, new Item("Pulp Planet Mouse Pad", 9.99));
        items.put(3, new Item("Pulp Planet Stickers", 4.99));
        items.put(4, new Item("Pulp Planet Coffee Mug", 12.99));
        items.put(5, new Item("Pulp Planet Bookmark", 2.99));
        items.put(6, new Item("Pulp Planet Hat", 14.99));
    }

    public void listCatalogSimple() {
        System.out.println("=== Pulp Planet Order Catalog ===");
        for (Map.Entry<Integer, Item> entry : items.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue().getName());
        }
    }

    public Item getItem(int itemNumber) {
        return items.get(itemNumber);
    }
}

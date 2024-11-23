package basicPortfolio.ecomapp.order;

import java.util.HashMap;
import java.util.Map;

public class Catalog {
    private Map<Integer, Item> items;

    public Catalog() {
        items = new HashMap<>();
        items.put(1, new Item("Desktop", 500.0));
        items.put(2, new Item("Laptop", 700.0));
        items.put(3, new Item("Tablet", 300.0));
        items.put(4, new Item("VoIP Device", 150.0));
        items.put(5, new Item("Printer", 200.0));
        items.put(6, new Item("Monitor", 250.0));
        items.put(7, new Item("Keyboard", 50.0));
        items.put(8, new Item("Mouse", 25.0));
    }

    public void listCatalogSimple() {
        System.out.println("=== Catalog ===");
        for (Map.Entry<Integer, Item> entry : items.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue().getName());
        }
    }

    public Item getItem(int itemNumber) {
        return items.get(itemNumber);
    }
}

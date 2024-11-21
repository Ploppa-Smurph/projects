package basicPortfolio.ecomapp.order;

import java.util.HashMap;
import java.util.Map;

public class Catalog {
    private Map<Integer, Item> items;

    public Catalog() {
        items = new HashMap<>();
        initializeCatalog();
    }

    private void initializeCatalog() {
        items.put(1, new Item("Desktop", 500.00));
        items.put(2, new Item("Laptop", 700.00));
        items.put(3, new Item("Tablet", 300.00));
        items.put(4, new Item("VoIP Device", 150.00));
        items.put(5, new Item("Printer", 200.00));
        items.put(6, new Item("Monitor", 250.00));
        items.put(7, new Item("Keyboard", 50.00));
        items.put(8, new Item("Mouse", 25.00));
    }

    public Item getItem(int itemId) {
        return items.get(itemId);
    }

    public void listCatalog() {
        for (Map.Entry<Integer, Item> entry : items.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue());
        }
    }
}

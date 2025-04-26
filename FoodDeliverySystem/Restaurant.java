//The **Restaurant** class represents a restaurant that offers menu items. It contains restaurant details such as ID, name, address, and a list of menu items. It provides methods to add and remove menu items.

// Additional attributes to consider:
// - Boolean to indicate if the restaurant is open
// - List of orders taken by the restaurant
// - List of customers who have ordered from the restaurant
// - List of reviews received by the restaurant
// - Rating for the restaurant

package FoodDeliverySystem;

import java.util.List;

public class Restaurant {

    private final String id;
    private final String name;
    private final String address;
    private final List<MenuItem> menu;

    public Restaurant(String id, String name, String address, List<MenuItem> menu) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.menu = menu;

    }

    public String getId() {
        return id;
    }

    public List<MenuItem> getMenu() {
        return menu;
    }

    public void addMenuItem(MenuItem item) {
        menu.add(item);
    }

    public void removeMenuItem(MenuItem item) {
        menu.remove(item);
    }

}

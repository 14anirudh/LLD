// 3. The **MenuItem** class represents an item on a restaurant's menu. It contains details such as ID, name, description, price, and availability status.

// Additional attributes to consider:
// - Rating for the menu item
// - Nutritional information
// - Boolean to indicate if the item is healthy
// - Boolean to indicate if the item is vegetarian
// - Type of Meal , e.g., breakfast, lunch, dinner
// - Boolean to indicate if a add on or a proper dish

package FoodDeliverySystem;

public class MenuItem {
    private final String id;
    private final String name;
    private final String description;
    private final double price;
    private boolean availability;

    public MenuItem(String id, String name, String description, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.availability = true;
    }

    public String getId() {
        return id;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
}

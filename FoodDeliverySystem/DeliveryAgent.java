//7. The **DeliveryAgent** class represents a delivery agent who fulfills orders. It contains details such as ID, name, phone number, and availability status.
//
//Additional attributes to consider
//- Rating for the delivery agent
//- List of orders assigned to the agent
//- List of reviews received by the agent
//- Area for quick delivery can be added

package FoodDeliverySystem;

public class DeliveryAgent {
    private final String id;
    private final String name;
    private final String phoneNumber;
    private boolean availability;

    public DeliveryAgent(String id, String name, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.availability = true;
    }

    public String getId() {
        return id;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public boolean getAvailability() {
        return availability;
    }
}

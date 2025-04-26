package FoodDeliverySystem.Order;

public enum OrderStatus {
    PENDING,
    CONFIRMED,
    PREPARING,
    READY_FOR_PICKUP, // new addition
    OUT_FOR_DELIVERY,
    RETURNED,
    FAILED, // new addition
    DELIVERED, // new addition
    CANCELLED;// new addition

}

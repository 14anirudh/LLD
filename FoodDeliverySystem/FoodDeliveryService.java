package FoodDeliverySystem;

import FoodDeliverySystem.Order.Order;
import FoodDeliverySystem.Order.OrderItem;
import FoodDeliverySystem.Order.OrderStatus;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class FoodDeliveryService {
    private static FoodDeliveryService instance;
    private final Map<String, Customer> customers;
    private final Map<String, Restaurant> restaurants;
    private final Map<String, Order> orders;
    private final Map<String, DeliveryAgent> deliveryAgents;

    private FoodDeliveryService() {
        customers = new ConcurrentHashMap<>();
        restaurants = new ConcurrentHashMap<>();
        orders = new ConcurrentHashMap<>();
        deliveryAgents = new ConcurrentHashMap<>();
    }

    public static synchronized FoodDeliveryService getInstance() {
        if (instance == null) {
            instance = new FoodDeliveryService();
        }
        return instance;
    }

    public void registerCustomer(Customer customer) {
        customers.put(customer.getId(), customer);
    }

    public void registerRestaurant(Restaurant restaurant) {
        restaurants.put(restaurant.getId(), restaurant);
    }

    public void registerDeliveryAgent(DeliveryAgent agent) {
        deliveryAgents.put(agent.getId(), agent);
    }

    public List<Restaurant> getAvailableRestaurants() {
        return new ArrayList<>(restaurants.values());
    }

    public List<MenuItem> getRestaurantMenu(String restaurantId) {
        Restaurant restaurant = restaurants.get(restaurantId);
        if (restaurant != null) {
            return restaurant.getMenu();
        }
        return new ArrayList<>();

    }

    public Order placeOrder(String customerId, String restaurantId, List<OrderItem> items) {
        Customer customer = customers.get(customerId);
        Restaurant restaurant = restaurants.get(restaurantId);
        if (customer != null && restaurant != null) {
            Order order = new Order(generateOrderId(), customer, restaurant);
            for (OrderItem item : items) {
                order.addItem(item);
            }
            orders.put(order.getId(), order);
            notifyRestaurant(order);
            System.out.println("Order created successfully. Order ID: " + order.getId());
            return order;

        }
        return null;
    }

    public void updateOrderStatus(String orderId, OrderStatus status) {
        Order order = orders.get(orderId);
        if (order != null) {
            order.setStatus(status);
            notifyCustomer(order);
            if (status == OrderStatus.CONFIRMED) {
                assignDeliveryAgent(order);
            }
        }
    }

    public void assignDeliveryAgent(Order order) {
        for (DeliveryAgent agent : deliveryAgents.values()) {
            if (agent.getAvailability()) {
                agent.setAvailability(false);
                order.assignDeliveryAgent(agent);
                notifyDeliveryAgent(order);
                break;
            }
        }
    }

    public void cancelOrder(String orderId) {
        Order order = orders.get(orderId);
        if (order != null && order.getStatus() == OrderStatus.PENDING) {
            order.setStatus(OrderStatus.CANCELLED);
            notifyCustomer(order);
            notifyRestaurant(order);
            System.out.println("Order cancelled successfully. Order ID: " + order.getId());
        }
    }

    private String generateOrderId() {
        return "ORD" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    private void notifyRestaurant(Order order) {
        // Send notification to the restaurant about the new order or order status
        // update
        // ...
    }

    private void notifyCustomer(Order order) {
        // Send notification to the customer about the order status update
        // ...
    }

    private void notifyDeliveryAgent(Order order) {
        // Send notification to the delivery agent about the assigned order
        // ...
    }

}
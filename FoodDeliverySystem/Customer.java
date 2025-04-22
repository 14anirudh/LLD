package FoodDeliverySystem;

public class Customer{
    private final String id;
    private final String name;
    private final String email;
    private final String phone;
    private final String address;

    public Customer(String id , String name , String email, String phone, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public String getId(){
        return id ;
    }
 
}

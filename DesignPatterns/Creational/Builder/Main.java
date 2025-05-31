package Creational.Builder;

public class Main {
    public static void main(String[] args) {
        User user = new User.Builder("John", 30).email("john@example.com").build();
        System.out.println(user);
    }
}

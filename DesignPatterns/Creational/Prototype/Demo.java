package Creational.Prototype;

import java.util.List;

public class Demo {
    public static void main(String[] args){
        Book original = new Book("Java Basics", "John Doe", List.of("Java", "OOP"));

        // FIRST APPROACH USING CLONABLE INTERFACE
        // Book cloned = original.clone();
        // cloned.setTitle("Cloned book");;
        

        // SECOND APPROACH USING COPY CONSTRUCTOR
        Book cloned = new Book(original);

        cloned.setTitle("modi copy");

       original.print();
        cloned.print();

    }
}

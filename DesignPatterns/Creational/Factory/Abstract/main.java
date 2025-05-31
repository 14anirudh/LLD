package Creational.Factory.Abstract;

public class main {
    public static void main(String[] args) {
        AbstractFactoryProducer producer = new AbstractFactoryProducer();
        AbstarctFactory factory = producer.getFactoryInstance("Economic");
        Car car = factory.getInstance(100000);
        System.out.println(car.getTopSpeed()); 
    }
}
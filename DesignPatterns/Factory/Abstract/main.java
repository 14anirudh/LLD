package DesignPatterns.Factory.Abstract;

public class main {
    public static void main(String[] args) {
        AbstarctFactory factory = new EconomicCarFactory();
        Car car = factory.getInstance(100000);
        System.out.println(car.getTopSpeed()); 
    }
}
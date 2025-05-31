package Creational.Factory.Abstract;

public class EconomicCarFactory implements AbstarctFactory {
    public Car getInstance(int price){
        if(price<100000){
           return new EconomicCar1(); 
        }   
        else if(price<200000){
            return new EconomicCar2();  
        }   
        return null;
    }
}

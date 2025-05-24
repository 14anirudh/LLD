package DesignPatterns.Factory.Abstract;

public class LuxoryCarFactory implements AbstarctFactory {
    public Car getInstance(int price){
        if(price<100000){
           return new LuxoryCar1();
        }
        else if(price<200000){
            return new LuxoryCar2();
        }
        return null;
    }
}

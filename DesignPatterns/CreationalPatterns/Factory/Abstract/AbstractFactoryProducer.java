package DesignPatterns.Factory.Abstract;

public class AbstractFactoryProducer{
    
    public AbstarctFactory getFactoryInstance(String value){
        if(value.equals("Economic")){
           return new EconomicCarFactory(); 
        }
        else if(value.equals("Luxury")){
            return new LuxoryCarFactory(); 
        }

        return null;
    }
}

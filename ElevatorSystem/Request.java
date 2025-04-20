package ElevatorSystem;

public class Request {
   private final int sourceFloor;
   private final int destinationFloor;

   public Request(int sourceFloor , int destinationFloor){
    this.sourceFloor = sourceFloor;
    this.destinationFloor = destinationFloor;
   }

   public int getSourceFloor(){
    return sourceFloor;
  }

  public int getDestinationFloor(){
    return destinationFloor;    
  }

//   public int getDistance(){
//     return Math.abs(sourceFloor - destinationFloor); 
//   }


    
    
    @Override
    public String toString() {
        return "Request[From: " + sourceFloor + " To: " + destinationFloor + "]";
    }
}

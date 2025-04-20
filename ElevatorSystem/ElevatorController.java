package ElevatorSystem;

import java.util.ArrayList;
import java.util.List;

public class ElevatorController{
    private final List<Elevator> elevators;
   
    public ElevatorController(int numElevators , int capacity){
        elevators = new ArrayList<>();
        for(int i = 0 ; i < numElevators; i++){
            Elevator elevator = new Elevator(i+1 , capacity);
            elevators.add(elevator);
            new Thread(elevator::run).start();
       //For each Elevator instance, it creates a new Thread . The task assigned to this thread is the run method of the specific elevator object (using the method reference elevator::run ). It then immediately starts this thread using .start() . This means each elevator will begin operating concurrently as soon as the controller is initialized. (This assumes the `Elevator` class has a run method, likely implementing the Runnable interface or extending Thread ).
        }
    }

    public void requestElevator(int sourceFloor, int destinationFloor){
       Elevator optimalElevator = findOptimalElevator(sourceFloor, destinationFloor);
       optimalElevator.addRequest(new Request(sourceFloor, destinationFloor)); 
    }

    private Elevator findOptimalElevator(int sourceFloor, int destinationFloor){
       Elevator optimElevator = null;
       int minDistance = Integer.MAX_VALUE;
       
       for(Elevator elevator : elevators){
        int distance  = Math.abs(sourceFloor - elevator.getCurrentFloor());
        if(distance < minDistance){
            minDistance = distance;
            optimElevator = elevator;
        }
       }
       return optimElevator;
    }

}

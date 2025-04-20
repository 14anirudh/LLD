package ElevatorSystem;
import java.util.List;
import java.util.ArrayList;

public class Elevator {

    private final int id;
    private final int capacity;
    private int currentFloor;
    private Direction currentDirection;
    private final List<Request> requests;

    public Elevator(int id , int capacity){
        this.id = id ;
        this.capacity = capacity;
        this.currentFloor = 1;
        this.currentDirection = Direction.UP;
        this.requests = new ArrayList<>();
    }


  //Producer-Consumer Pattern
  // addRequest is the producer method that adds requests to the queue
  //getNextRequest is the consumer method that retrieves requests from the queue

    public synchronized void addRequest(Request request){
        //synchronized -> This makes the method thread-safe. Only one thread can execute this method at a time for a given Elevator object, preventing race conditions when multiple threads try to add requests simultaneously.
     if(requests.size() < capacity){
        requests.add(request);
        System.out.println("Elevator " + id  + " added request -> " + request);
        notifyAll();
        //This wakes up all threads that are waiting on this object's monitor. This is part of Java's thread synchronization mechanism. It's likely that there's another method in this class that waits for requests to be added before processing them.
     }
    }

    public synchronized Request getNextRequest(){
        while(requests.isEmpty()){
            try{
                wait();
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }

        return requests.remove(0);

    }

    public synchronized void processRequests(){
        while(true){
            while(!requests.isEmpty()){
                Request request = getNextRequest();
                processRequest(request);
            }
            try{
                wait();
                //The thread calls wait() , which causes it to release the lock on the Elevator object and wait until another thread calls notify() or notifyAll() on the same object.
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    private void processRequest(Request request){
        // First move to source floor
        int sourceFloor = request.getSourceFloor();
        int destinationFloor = request.getDestinationFloor();
        
        // Move to source floor
        moveToFloor(sourceFloor);
        
        // Stop at source floor for 3 seconds to pick up passengers
        System.out.println("Elevator " + id + " stopped at floor " + sourceFloor + ". Passengers boarding...");
        try {
            Thread.sleep(3000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        
        // Move to destination floor
        moveToFloor(destinationFloor);
        System.out.println("Elevator " + id + " stopped at floor " + destinationFloor + ". Passengers deboarding...");
        try {
            Thread.sleep(3000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        
    }

    private void moveToFloor(int targetFloor) {
        int startFloor = currentFloor;
        
        if(startFloor < targetFloor) {
            currentDirection = Direction.UP;
            for(int i = startFloor; i <= targetFloor; i++) {
                currentFloor = i;
                System.out.println("Elevator " + id + " is at floor " + currentFloor);
                try {
                    Thread.sleep(1000);
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else if(startFloor > targetFloor) {
            currentDirection = Direction.DOWN;
            for(int i = startFloor; i >= targetFloor; i--) {
                currentFloor = i;
                System.out.println("Elevator " + id + " is at floor " + currentFloor);
                try {
                    Thread.sleep(1000);
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void run(){
        processRequests();
    }

    public int getCurrentFloor(){
        return currentFloor;
    }



}

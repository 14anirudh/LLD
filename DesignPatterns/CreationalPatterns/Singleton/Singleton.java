public class Singleton {

    private static volatile Singleton instance;
    private String data;
    /*
 VOlATILE keyword 
 -> it tells JVM that the variable can be accessed by multiple thread so every read and write must go to and fro from the main memory 
 If we dont use volatile then there could be a case when some thread is intializing the instance it had done it partially and then another thread comes it could see a not null or incomplete constructed instance which can lead to errors
 */

    private Singleton(String data) {
        this.data = data;
    }

    public static Singleton getInstance(String data) {

        Singleton result = instance;
        // since we have made the instance volatile we would read it directly from main memory everytime
        // so after initializing instance once we have to access it from memory twice line 12 & 20 .
        // So we can store it in a local variable to avoid extra memory accesses

        if (result == null) {
            // we have added this to check before locking that the instance is already instamtiated or not to improve performance,Also if the instance is already there we need not to put a lock
            synchronized (Singleton.class) {
                //lock for preventing race conditions
                result = instance;
                if (result == null) {
                 // double checking to prevent creating a second instance 
                 // suppose a thread has got a lock but by then some other thread had already created the instance so we can avoid the situtaion of creating the object again    
                    result = new Singleton(data);
                }
            }

        }

        return instance;
    }
}



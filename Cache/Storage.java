package Cache;

import java.util.Map;
import java.util.HashMap;

public class Storage {
    Map<String, String> storage ;
    private final int capacity;

    public Storage(int capacity) {
        this.capacity = capacity; 
        this.storage = new HashMap<>();
    }

    public void add(String key, String value){
        if(storage.size() == capacity && !storage.containsKey(key)){
         return;
        }
        storage.put(key, value);
    }

    public void remove(String key){
        if(!storage.containsKey(key)){
           return;
        }
        storage.remove(key);

    }

    public String get(String key){
        return storage.get(key);
    }
    
}

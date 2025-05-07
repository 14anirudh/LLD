package Cache;

public class Main {
    public static void main(String[] args) {
        // Create cache components
        Storage storage = new Storage(3); // Cache with capacity 3
        EvictionPolicy evictionPolicy = new EvictionPolicy();
        
        // Create cache with the components
        Cache cache = new Cache(storage, evictionPolicy);
        
        // Test operations
        System.out.println("Adding key1, value1");
        cache.put("key1", "value1");
        
        System.out.println("Adding key2, value2");
        cache.put("key2", "value2");
        
        System.out.println("Getting key1: " + cache.get("key1"));
        
        System.out.println("Adding key3, value3");
        cache.put("key3", "value3");
        
        System.out.println("Adding key4, value4 (should evict key2)");
        cache.put("key4", "value4");
        
        System.out.println("Getting key2 (should be null): " + cache.get("key2"));
        System.out.println("Getting key1 (should exist): " + cache.get("key1"));
        System.out.println("Getting key3 (should exist): " + cache.get("key3"));
        System.out.println("Getting key4 (should exist): " + cache.get("key4"));
    }
}

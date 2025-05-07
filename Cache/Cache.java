package Cache;

public class Cache {
    private final Storage storage;
    private final EvictionPolicy evictionPolicy;
   
    public Cache(Storage storage, EvictionPolicy evictionPolicy) {
        this.storage = storage;
        this.evictionPolicy = evictionPolicy;
    }

    public void put(String key , String value){
        storage.add(key, value);
        evictionPolicy.keyAccessed(key,value);
    }

    public String get(String key){
      String value = storage.get(key);
      evictionPolicy.keyAccessed(key,value);
      return value;
    }
}

package Cache;

import java.util.HashMap;

public class EvictionPolicy {
    private DoubleyLinkedList dll;
    private HashMap<String , Node> map;

    public EvictionPolicy(){
        this.dll = new DoubleyLinkedList();
        this.map = new HashMap<>();
    }

    public void keyAccessed(String key, String value){
        if(!map.containsKey(key)){
           Node node = new Node(key,value);
           map.put(key, node);
           dll.attachAtEnd(node); 
        }
        dll.detachNode(map.get(key));
        dll.attachAtEnd(map.get(key));
    }

    public String evictKey(){
        if(dll.getHead() == null) {
            return null;
        }
        String keyToEvict = dll.getHead().getKey();
        map.remove(keyToEvict);
        dll.moveHead();
        return keyToEvict;
    }

}

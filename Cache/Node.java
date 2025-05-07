package Cache;

public class Node {
     String key;
     String value;
     Node next;
     Node prev;

    public Node(String key, String value) {
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
    }

    public String getKey() {
        return key;
    }
}

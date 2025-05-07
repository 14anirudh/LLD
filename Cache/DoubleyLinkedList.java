package Cache;

public class DoubleyLinkedList {
    private Node head;
    private Node tail;
    

    public DoubleyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    
    public void detachNode(Node node){
        if(node == null) return;
        
        if(node == head){
            if(head == tail) {
                head = null;
                tail = null;
                return;
            }
            head = head.next;
            if(head != null) {
                head.prev = null;
            }
        }
        else if(node == tail){
            tail = tail.prev;
            if(tail != null) {
                tail.next = null;
            }
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }


    public void attachAtEnd(Node node){
        if(head == null){
            head = node;
            tail = node; 
        }
        else{
            tail.next = node;
            node.prev = tail;
            tail = node; 
        }   
        
    }

    public void moveHead(){
        head = head.next;
        head.prev=null;
    }

    public Node getHead() {
        return head;
    }
    
}

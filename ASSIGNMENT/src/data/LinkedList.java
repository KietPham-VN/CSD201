package data;

public class LinkedList {

    private class Node {
        String data;
        Node next;

        public Node(String title) {
            this.data = title;
            this.next = null;
        }
    }
    
    private Node head;

    public LinkedList() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void add(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public int size() {
        if (head == null) {
            return 0;
        }
        Node current = head;
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public void display() {
        int count = 1;
        Node current = head;
        while (current != null) {
            System.out.println(count + ". " + current.data);
            current = current.next;
            count++;
        }
    }

    public boolean delete(String data) {
        int delete_idx = indexOf(data);
        if(delete_idx == -1){
            return false;
        }
        
         //head is the removed one
        if(delete_idx == 0) {
            head = head.next;
            return true;
        }
        
        // The node is being removed which is at right of the head
        Node current = head ;
        int pos = 0;
        while(pos < delete_idx){
            current = current.next;
            pos++;
        }
        current.next = current.next.next;
        return true;
    }

    public boolean exist(String data) {
        if (this.head == null) {
            return false;
        }
        Node current = this.head;
        while (current != null) {
            if (current.data.equalsIgnoreCase(data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    public int indexOf(String data) {
        if (this.head == null) {
            return -1;
        }
        Node current = this.head;
        int i = 0;
        while (current != null) {
            if (current.data.equalsIgnoreCase(data)) {
                return i;
            }
            current = current.next;
            i++;
        }
        return -1;
    }
    
    public void search(String data) {
        if(head == null) {
            return;
        }
        Node current = head;
        int count = 1;
        while(current != null) {
            if(current.data.toLowerCase().contains(data.trim().toLowerCase())) {
                System.out.print(count + ": ");
                System.out.println(current.data);
            }
            current = current.next;
            count++;
        }
        
    }
    
    
}

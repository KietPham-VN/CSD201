package data;

public class BorrowedList {

    private class Node {
        Book book;
        Node next;

        public Node(Book book) {
            this.book = book;
            this.next = null;
        }
    }
    
    private Node head;

    public BorrowedList() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void add(Book book) {
        Node newNode = new Node(book);
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
            System.out.println(count + ". " + current.book.toString());
            current = current.next;
            count++;
        }
        if(count == 1) {
            System.out.println("no books");
        }
    }

    
    public Book delete(int ID) {
        if(head == null) {
            return null;
        }
        if(head.book.getID() == ID) {
            Book temp = head.book;
            head = head.next;
            return temp;
        }
        
        //From now on, the deleted node must be at the right of the head
        Node current = head;
        while(current.next != null && current.next.book.getID() != ID) {
            current = current.next;
        }
        
        //if the pointer current traverse to the last node of the linkedlist, it surely to be not found
        if(current.next == null) {
            return null;
        }
        Book temp = current.next.book;
        current.next = current.next.next;
        return temp;
    }

    public boolean existTitle(String title) {
        if (this.head == null) {
            return false;
        }
        Node current = this.head;
        while (current != null) {
            if (current.book.getTitle().toLowerCase().equalsIgnoreCase(title.trim().toLowerCase())) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    public boolean existAuthor(String author) {
        if (this.head == null) {
            return false;
        }
        Node current = this.head;
        while (current != null) {
            if (current.book.getAuthor().toLowerCase().equalsIgnoreCase(author.trim().toLowerCase())) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    public boolean existID(int ID) {
        if (this.head == null) {
            return false;
        }
        Node current = this.head;
        while (current != null) {
            if (current.book.getID() == ID) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    public int indexOf(int ID) {
        if (this.head == null) {
            return -1;
        }
        Node current = this.head;
        int i = 0;
        while (current != null) {
            if (current.book.getID() == ID) {
                return i;
            }
            current = current.next;
            i++;
        }
        return -1;
    }
    
    public void searchTitle_BorrowedList(String search_str) {
        if(head == null) {
            return;
        }
        Node current = head;
        int count = 0;
        System.out.println("Qualified List");
        while(current != null) {
            if(current.book.getTitle().toLowerCase().equalsIgnoreCase(search_str.toLowerCase())) {
                System.out.print((count+1) + ": ");
                System.out.println(current.toString());
                count++;
            }
            current = current.next;
            
        }
        if(count == 0) {
            System.out.println("no books");
        }
        
    }
    
    public void searchAuthor_BorrowedList(String search_str) {
        if(head == null) {
            return;
        }
        Node current = head;
        int count = 0;
        System.out.println("Qualified List");
        while(current != null) {
            if(current.book.getAuthor().toLowerCase().equalsIgnoreCase(search_str.toLowerCase())) {
                System.out.print((count+1) + ": ");
                System.out.println(current.toString());
                count++;
            }
            current = current.next;
        }
        if(count == 0) {
            System.out.println("no books");
        }
        
    }
    
    public void searchID_BorrowedList(int ID) {
        if(head == null) {
            return;
        }
        Node current = head;
        int count = 0;
        System.out.println("Qualified List");
        while(current != null) {
            if(current.book.getID() == ID) {
                System.out.print((count+1) + ": ");
                System.out.println(current.toString());
                count++;
            }
            current = current.next;
            
        }
        if(count == 0) {
            System.out.println("no books");
        }
        
    }
    
    
}

package data;

public class BorrowedBookList {

    private class BorrowedBookNode {

        String title;
        BorrowedBookNode next;

        public BorrowedBookNode(String title) {
            this.title = title;
            this.next = null;
        }
    }
    private BorrowedBookNode head;

    public BorrowedBookList() {
        head = null;
    }

    public boolean isBorrowedListEmpty() {
        return head == null;
    }

    public void add(String title) {
        BorrowedBookNode newNode = new BorrowedBookNode(title);
        if (head == null) {
            head = newNode;
            return;
        }
        BorrowedBookNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public int size() {
        if (head == null) {
            return 0;
        }
        BorrowedBookNode current = head;
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public void displayBorrowedBooks() {
        int count = 1;
        System.out.println("Borrowed books:");
        BorrowedBookNode current = head;
        while (current != null) {
            System.out.println(count + ". " + current.title);
            current = current.next;
        }
    }
    
    public void traverse() {
        BorrowedBookNode current = head;
        while (current != null) {
            System.out.println(current.title + " -> ");
            current = current.next;
        }
    }

    public BorrowedBookNode RemoveBorrowedBook(String book) {
        if(head == null){
            return null;
        }
        
        BorrowedBookNode current = head;
        while (!current.next.title.equalsIgnoreCase(book)) {
            current = current.next;
        }
        BorrowedBookNode tmp = current.next;
//        trường hợp nếu mình remove book ở cuối cùng
        if(current.next.next == null){
            
            current.next = null;
            return tmp;
        }
//        xóa borrowedBook
        current.next = current.next.next;
        return tmp;
    }
    
    public void insert(String title) {
        BorrowedBookNode bookNode = new BorrowedBookNode(title);
        if (head == null) {
            head = bookNode;
            return;
        }
        BorrowedBookNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = bookNode;
    }
    
    public void search(String title){
        if(this.head == null){
            System.out.println("BorrowedList Is Empty");
            return;
        }
        BorrowedBookNode current = this.head;
        while(current != null){
            if(current.title.equals(title)){
                System.out.println(current.title);
                return;
            }
            current = current.next;
        }
        System.out.println("Not Found");
    }
}

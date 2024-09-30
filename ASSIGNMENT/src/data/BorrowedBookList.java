package data;

public class BorrowedBookList {

    public class BorrowedBookNode {

        String title;
        BorrowedBookNode next;

        public BorrowedBookNode(String title) {
            this.title = title;
            this.next = null;
        }
    }
    public static BorrowedBookNode head;

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
            count++;
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
//        trường hợp book ở đầu tiên
        if(current.title.equalsIgnoreCase(book)) {
            head = current.next; 
            return current;
        }

//        chạy từ phần từ thứ hai chở đi
        while(current.next != null){
            if(current.next.title.equalsIgnoreCase(book)){
                break;
            }
            current = current.next;
        }
//        trường hợp ko có book trong borrowedBook
        if(current.next == null) return null;
//        trường hợp book ở cuối danh sách
        if(current.next.next == null){
            current.next = null;
        }
        BorrowedBookNode tmp = current;
        current.next = current.next.next;
        return current.next;
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

    public void search(String title) {
        if (this.head == null) {
            System.out.println("BorrowedList Is Empty");
            return;
        }
        BorrowedBookNode current = this.head;
        while (current != null) {
            if (current.title.equals(title)) {
                System.out.println(current.title);
                return;
            }
            current = current.next;
        }
        System.out.println("Not Found");
    }

    public int find(String title) {
        int pos = 0;
        BorrowedBookNode current = head;
        if (head == null) {
            return -1;
        }
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                return pos;
            }
            pos++;
            current = current.next;
        }
        return -1;
    }
}

package data;

public class Library {

    private String[] avail_list;
    private int quantity;
    private LinkedList borrowed_list;

    public Library() {
        avail_list = new String[10];
        quantity = 0;
        borrowed_list = new LinkedList();
    }

    public void add(String title) {
        if (quantity + 1 > avail_list.length) {
            resize();
        }
        avail_list[quantity] = title;
        quantity++;
    }

    public void resize() {
        // increase size by 50%
        String[] temp = new String[avail_list.length + avail_list.length / 2];
        for (int i = 0; i < quantity; i++) {
            temp[i] = avail_list[i];
        }
        avail_list = temp;
    }

    public void displayAvailList() {
        int count = 1;
        System.out.println("____________Avail books__________");
        for (int i = 0; i < quantity; i++) {
            System.out.println(count + ". " + avail_list[i]);
            count++;
        }
        System.out.println("");
    }
    
    public void displayBorrowedList() {
        System.out.println("__________Borrowed books_________");
        borrowed_list.display();
        System.out.println("");
    }

    public void getStatus(String title) {
        System.out.print("Status of \"" + title + "\": ");
        if(borrowed_list.exist(title) == true) {
            System.out.println("Already borrowed");
            return;
        }
        if(exist(title) == true) {
            System.out.println("Available");
            return;
        }
        System.out.println("Not exists in the library system");
    }

    // muon sach
    public boolean borrowBook(String title) { 
        if(borrowed_list.exist(title)) {
            System.out.println("Already borrowed!");
            return false;
        }
        if(exist(title) == false) {
            System.out.println("Not exists in system");
            return false;
        }
        delete(title);
        // them vao borrowed book
        borrowed_list.add(title);
        return true;
    }

    public boolean returnBook(String title) {
        if(borrowed_list.delete(title) == false) {
            System.out.println("Not exists in Borrowed List!");
            return false;
        }
        add(title);
        return true;
    }
    
    public boolean exist(String title) {
        for (int i = 0; i < quantity; i++) {
            if (avail_list[i].equalsIgnoreCase(title)) {
                return true;
            }
        }
        return false;
    }
    
    public int indexOf(String title) {
        for (int i = 0; i < quantity; i++) {
            if (avail_list[i].equalsIgnoreCase(title)) {
                return i;
            }
        }
        return -1;
    }

    public boolean delete(String title) {
        int delete_idx = indexOf(title);
        if (delete_idx == -1) {
            return false;
        }
        for (int i = delete_idx; i < quantity - 1; i++) {
            avail_list[i] = avail_list[i + 1];
        }
        quantity--;
        return true;
    }
    
    public void searchAvailList(String search_str) {
        System.out.println("Qualified list:");
        for(int i = 0; i < quantity; i++) {
            if(avail_list[i].toLowerCase().contains(search_str.trim().toLowerCase())) {
                System.out.println((i+1) + ": " + avail_list[i]);
            }
        }
        System.out.println("");
    }
    
    public void searchBorrowedList(String search_str) {
        System.out.println("Qualified list:");
        borrowed_list.search(search_str);
        System.out.println("");
    }

}

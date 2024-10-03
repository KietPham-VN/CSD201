package data;

import java.util.Scanner;

public class Library {

    private Book[] avail_list;
    private int quantity;
    public BorrowedList borrowed_list;

    public Library() {
        avail_list = new Book[10];
        quantity = 0;
        borrowed_list = new BorrowedList();
    }

    public void add(Book book) {
        if (quantity + 1 > avail_list.length) {
            resize();
        }
        avail_list[quantity] = book;
        quantity++;
    }

    public void resize() {
        // increase size by 100%
        Book[] temp = new Book[avail_list.length * 2];
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
        if(count == 1) {
            System.out.println("no books");
        }
        System.out.println("");
    }
    
    public void getStatus(int ID) {
        System.out.print("Status of \"" + ID + "\": ");
        if(borrowed_list.existID(ID) == true) {
            System.out.println("Already borrowed");
            return;
        }
        if(existID(ID) == true) {
            System.out.println("Available");
            return;
        }
        System.out.println("Not exists in the library system");
    }

    // muon sach
    public boolean borrowBook(int ID) { 
        if(borrowed_list.existID(ID)) {
            System.out.println("Already borrowed!");
            return false;
        }
        if(existID(ID) == false) {
            System.out.println("Not exists in system");
            return false;
        }
        Book temp = delete(ID);
        // them vao borrowed book
        borrowed_list.add(temp);
        return true;
    }

    public boolean returnBook(int ID) {
        Book delete_book = borrowed_list.delete(ID);
        if(delete_book == null) {
            System.out.println("Not exists in Borrowed List!");
            return false;
        }
        add(delete_book);
        return true;
    }
    
    public int indexOf(int ID) {
        for (int i = 0; i < quantity; i++) {
            if (avail_list[i].getID() == ID) {
                return i;
            }
        }
        return -1;
    }

    public Book delete(int ID) {
        int delete_idx = indexOf(ID);
        if (delete_idx == -1) {
            return null;
        }
        Book temp = avail_list[delete_idx];
        for (int i = delete_idx; i < quantity - 1; i++) {
            avail_list[i] = avail_list[i + 1];
        }
        quantity--;
        return temp;
    }
    
    public int subMenu() {
        int choice = 0;
        do {
            try {
            Scanner sc = new Scanner(System.in);
            System.out.println("--------------SUB SEARCH MENU-------------------");
            System.out.println("1. SearchByID");
            System.out.println("2. SearchByTitle");
            System.out.println("3. SearchByAuthor");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input choice!");
                continue;
            }
            return choice;
        } while(true);
    }
    
    public void searchID_AvailList(int ID) {
        System.out.println("Qualified list:");
        int count = 0;
        for(int i = 0; i < quantity; i++) {
            if(avail_list[i].getID() == ID) {
                System.out.println((count+1) + ": " + avail_list[i]);
                count++;
            }
        }
        if(count == 0) {
            System.out.println("no books");
        }
        System.out.println("");
    }
    
    public void searchTiltle_AvailList(String search_str) {
        System.out.println("Qualified list:");
        int count = 0;
        for(int i = 0; i < quantity; i++) {
            if(avail_list[i].getTitle().contains(search_str.trim().toLowerCase())) {
                System.out.println((count+1) + ": " + avail_list[i]);
                count++;
            }
        }
        if(count == 0) {
            System.out.println("no books");
        }
        System.out.println("");
    }
    
    public void searchAuthor_AvailList(String search_str) {
        System.out.println("Qualified list:");
        int count = 0;
        for(int i = 0; i < quantity; i++) {
            if(avail_list[i].getAuthor().contains(search_str.trim().toLowerCase())) {
                System.out.println((count+1) + ": " + avail_list[i]);
                count++;
            }
        }
        if(count == 0) {
            System.out.println("no books");
        }
        System.out.println("");
    }
    
    public boolean existID(int ID) {
        for (int i = 0; i < quantity; i++) {
            if (avail_list[i].getID() == ID) {
                return true;
            }
        }
        return false;
    }
    
    public boolean existTitle(String title) {
        for (int i = 0; i < quantity; i++) {
            if (avail_list[i].getTitle().toLowerCase().contains(title.trim().toLowerCase())) {
                return true;
            }
        }
        return false;
    }
    
    public boolean existAuthor(String author) {
        for (int i = 0; i < quantity; i++) {
            if (avail_list[i].getAuthor().toLowerCase().contains(author.trim().toLowerCase())) {
                return true;
            }
        }
        return false;
    }

}

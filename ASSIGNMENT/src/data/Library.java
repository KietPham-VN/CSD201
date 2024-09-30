package data;

public class Library {

    private String[] books;
    private int bookCount;
    private BorrowedBookList borrowedBooks;

    public Library() {
        books = new String[10];
        bookCount = 0;
        borrowedBooks = new BorrowedBookList();
    }

    public void add(String title) {
        if (bookCount + 1 > books.length) {
            resize();
        }
        books[bookCount] = title;
        bookCount++;
    }

    public void resize() {
        String[] temp = new String[books.length + books.length / 2];
        for (int i = 0; i < bookCount; i++) {
            temp[i] = books[i];
        }
        books = temp;
    }

    public boolean returnBook(String title) {
        borrowedBooks.RemoveBorrowedBook(title);
        books[bookCount++] = title;
        return true;
    }
    
     // Method in tất cả sách hiện có trong thư viện
    public void displayBooks() {
        int count = 1;
        System.out.println("Books available in the library:");
        for (int i = 0; i < bookCount; i++) {
            System.out.println(count + ". " + books[i]);
            count++;
        }
    }
    public void search(String title){
        if(bookCount == 0){
            System.out.println("Library Is Empty");
            return;
        }
        for(int i = 0;i < bookCount;i++){
            if(books[i].equals(title)){
                System.out.println(books[i]);
                return;
            }
        }
        
        System.out.println("Not Found");
    }
}

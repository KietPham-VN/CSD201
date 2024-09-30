package data;

public class Library {

    private String[] books;
    private int bookCount;
    public BorrowedBookList borrowedBooks;

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
        if (borrowedBooks.RemoveBorrowedBook(title) == null) {
            return false;
        }
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

    public void getStatus(String title) {
        if (find(title) == -1) {
            if (borrowedBooks.find(title) == -1) {
                System.out.println("not in the library at all.");
            } else {
                System.out.println("borrowed");
            }
        } else {
            System.out.println("available");
        }
    }

    // muon sach
    public void borrowBook(String title) { 
        for (int i = 0; i < bookCount; i++) {
            if (books[i].equals(title)) {
                for (int j = i; j < bookCount - 1; j++) {
                    books[j] = books[j + 1];
                }
                bookCount--;

                // them vao borrowed book
                borrowedBooks.add(title);
                System.out.println("'" + title + "' has been borrowed.");
                return;
            }
        }
        System.out.println("'" + title + "' is not available in the library.");
    }

    public int find(String title) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].equalsIgnoreCase(title)) {
                return i;
            }
        }
        return -1;
    }

    public void delete(String title) {
        int delete_idx = find(title);
        if (delete_idx == -1) {
            System.out.println("Not found");
            return;
        }
        for (int i = delete_idx; i < books.length; i++) {
            books[i] = books[i + 1];
        }
        bookCount--;
    }

}

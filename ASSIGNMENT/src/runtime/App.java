package runtime;

import data.Library;

public class App {

    public static void main(String[] args) {
        Library library = new Library();
        library.add("To Kill a Mockingbird");
        library.add("1984");
        library.add("Moby Dick");
        library.add("The Great Gatsby");
        library.add("War and Peace");
        library.add("Pride and Prejudice");
        library.add("The Catcher in the Rye");
        library.add("The Lord of the Rings");
        
        library.borrowBook("The Lord of the Rings");
        library.borrowBook("The Catcher in the Rye");
        
        library.returnBook("The Lord of the Rings");
        
        library.displayBooks();
        System.out.println("_________________________________________________________");
        library.borrowedBooks.displayBorrowedBooks();

        library.getStatus("The Lord of the Ring");
    }
}

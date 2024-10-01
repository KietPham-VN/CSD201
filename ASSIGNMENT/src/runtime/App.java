package runtime;

import data.Library;
import ui.Menu;
import utils.Inputter;

public class App {

    public static void addSampleBooks(Library library) {
        library.add("To Kill a Mockingbird");
        library.add("1984");
        library.add("Moby Dick");
        library.add("The Great Gatsby");
        library.add("War and Peace");
        library.add("Pride and Prejudice");
        library.add("The Catcher in the Rye");
        library.add("The Lord of the Rings");
    }

    public static void main(String[] args) {
        Library library = new Library();
        addSampleBooks(library);
        Menu menu = new Menu("Library Management System");

        // Thêm các lựa chọn vào menu
        menu.addNewOption("Add a new book");
        menu.addNewOption("Borrow a book");
        menu.addNewOption("Return a book");
        menu.addNewOption("Display available books");
        menu.addNewOption("Display borrowed books");
        menu.addNewOption("Exit");

        int choice;
        do {
            menu.print();
            choice = menu.getChoice();

            switch (choice) {
                case 1:
                    String title = Inputter.getString("Enter book title: ", "Book title is required.");
                    library.add(title);
                    System.out.println("'" + title + "' has been added to the library.");
                    break;

                case 2:
                    String borrowTitle = Inputter.getString("Enter the title of the book to borrow: ", "Book title is required.");
                    library.borrowBook(borrowTitle);
                    break;

                case 3:
                    String returnTitle = Inputter.getString("Enter the title of the book to return: ", "Book title is required.");
                    library.returnBook(returnTitle);
                    break;

                case 4:
                    library.displayAvailList();
                    break;

                case 5:
                    library.displayBorrowedList();
                    break;

                case 6:
                    System.out.println("Exiting the program...");
                    break;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }

            if (choice != 6 && !Menu.isContinue()) {
                break;
            }

        } while (choice != 6);
    }
}
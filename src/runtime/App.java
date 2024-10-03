package runtime;

import data.Book;
import data.Library;
import ui.Menu;
import utils.Inputter;

public class App {

    public static void addSampleBooks(Library library) {
        library.add(new Book("To Kill a Mockingbird", "Harper Lee"));
        library.add(new Book("1984", "George Orwell"));
        library.add(new Book("Moby Dick", "Herman Melville"));
        library.add(new Book("The Great Gatsby", "F. Scott Fitzgerald"));
        library.add(new Book("War and Peace", "Leo Tolstoy"));
        library.add(new Book("Pride and Prejudice", "Jane Austen"));
        library.add(new Book("The Catcher in the Rye", "J.D. Salinger"));
        library.add(new Book("The Lord of the Rings", "J.R.R. Tolkien"));
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
        menu.addNewOption("Searching a book in available books");
        menu.addNewOption("Searching a book in borrowed books");
        menu.addNewOption("Exit");

        Menu subMenu = new Menu("SubMenu 's Searching");
        subMenu.addNewOption("SearchByID");
        subMenu.addNewOption("SearchByTitle");
        subMenu.addNewOption("SearchByAuthor");
        
        
        int choice;
        do {
            menu.print();
            choice = menu.getChoice();

            switch (choice) {
                case 1:
                    String title = Inputter.getString("Enter book title: ", "Book title is required.");
                    String author = Inputter.getString("Enter book author: ", "Book author is required.");
                    library.add(new Book(title, author));
                    System.out.println("Book has been added to the library.");
                    break;

                case 2:
                    int ID = Inputter.getAnInteger("Enter the ID of the book to borrow: ", "Book title is required.");
                    library.borrowBook(ID);
                    break;

                case 3:
                    int ID_ = Inputter.getAnInteger("Enter the ID of the book to return: ", "Book title is required.");
                    library.returnBook(ID_);
                    break;

                case 4:
                    library.displayAvailList();
                    break;

                case 5:
                    library.borrowed_list.display();
                    break;
                    
                case 6:
                    subMenu.print();
                    int choice1 = subMenu.getChoice();
                    switch(choice1) {
                        case 1:
                            int id = Inputter.getAnInteger("Enter the ID of the book to search: ", "Book title is required.");
                            library.searchID_AvailList(id);
                            break;
                        case 2:
                            String str = Inputter.getString("Enter string to search: ", "Required not blank");
                            library.searchTiltle_AvailList(str);
                            break;
                        case 3:
                            String string = Inputter.getString("Enter string to search: ", "Required not blank");
                            library.searchTiltle_AvailList(string);
                    }
                    break;
                    
                case 7:
                    subMenu.print();
                    int choice2 = subMenu.getChoice();
                    
                    switch(choice2) {
                        case 1:
                            int id = Inputter.getAnInteger("Enter the ID of the book to search: ", "Book title is required.");
                            library.borrowed_list.searchID_BorrowedList(id);
                            break;
                        case 2:
                            String str = Inputter.getString("Enter string to search: ", "Required not blank");
                            library.borrowed_list.searchTitle_BorrowedList(str);
                            break;
                        case 3:
                            String string = Inputter.getString("Enter string to search: ", "Required not blank");
                            library.borrowed_list.searchAuthor_BorrowedList(string);
                    }
                    break;
                    
                case 8:
                    System.out.println("Exiting the program...");
                    break;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }

            if (choice != 8 && !Menu.isContinue()) {
                break;
            }

        } while (choice != 8);
    }
}
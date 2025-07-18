package LibraryManagement;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LibraryManager libraryManager = new LibraryManager();
        
        while (true) {
            System.out.println("Library Management System");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Update Book");
            System.out.println("4. Delete Book");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter publisher: ");
                    String publisher = scanner.nextLine();
                    System.out.print("Enter year: ");
                    int year = scanner.nextInt();
                    System.out.print("Enter available copies: ");
                    int availableCopies = scanner.nextInt();
                    Book newBook = new Book(0, title, author, publisher, year, availableCopies);
                    boolean added = libraryManager.addBook(newBook);
                    if (added) {
                        System.out.println("Book added successfully!");
                    } else {
                        System.out.println("Failed to add book.");
                    }
                    break;
                case 2:
                    List<Book> books = libraryManager.getAllBooks();
                    System.out.println("Books in the library:");
                    for (Book b : books) {
                        System.out.println(b.getBookId() + ": " + b.getTitle() + " by " + b.getAuthor());
                    }
                    break;
                case 3:
                    System.out.print("Enter book ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new title: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Enter new author: ");
                    String newAuthor = scanner.nextLine();
                    System.out.print("Enter new publisher: ");
                    String newPublisher = scanner.nextLine();
                    System.out.print("Enter new year: ");
                    int newYear = scanner.nextInt();
                    System.out.print("Enter new available copies: ");
                    int newAvailableCopies = scanner.nextInt();
                    Book updatedBook = new Book(updateId, newTitle, newAuthor, newPublisher, newYear, newAvailableCopies);
                    boolean updated = libraryManager.updateBook(updatedBook);
                    if (updated) {
                        System.out.println("Book updated successfully!");
                    } else {
                        System.out.println("Failed to update book.");
                    }
                    break;
                case 4:
                    System.out.print("Enter book ID to delete: ");
                    int deleteId = scanner.nextInt();
                    boolean deleted = libraryManager.deleteBook(deleteId);
                    if (deleted) {
                        System.out.println("Book deleted successfully!");
                    } else {
                        System.out.println("Failed to delete book.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

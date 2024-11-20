package com.tushar;
import java.util.ArrayList;
import java.util.Scanner;

public class BookManagementSystem {
    private static ArrayList<Book> books = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n1. Add Book");
            System.out.println("2. Display All Books");
            System.out.println("3. Search Book");
            System.out.println("4. Update Book");
            System.out.println("5. Remove Book");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    displayBooks();
                    break;
                case 3:
                    searchBook();
                    break;
                case 4:
                    updateBook();
                    break;
                case 5:
                    removeBook();
                    break;
                case 6:
                    System.out.println("Thank You!");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 6);

        scanner.close();
    }

    private static void addBook() {
        System.out.println("Enter Book Details:");

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("ID: ");
        String id = scanner.nextLine();

        System.out.print("Author: ");
        String author = scanner.nextLine();

        System.out.print("Price: ");
        double price = scanner.nextDouble();

        System.out.print("Rating: ");
        int rating = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        books.add(new Book(name, id, author, price, rating));
        System.out.println("Book added successfully!");
    }

    private static void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books to display.");
        } else {
            System.out.println("-------> All Books Details <-------");
            for (Book book : books) {
                book.displayBook();
            }
        }
    }

    private static void searchBook() {
        System.out.println("Search Book By:");
        System.out.println("a. Name");
        System.out.println("b. ID");
        System.out.println("c. Author");
        System.out.print("Enter your choice: ");
        char option = scanner.next().charAt(0);
        scanner.nextLine(); // Consume newline

        switch (option) {
            case 'a':
                System.out.print("Enter book name: ");
                String name = scanner.nextLine();
                searchByName(name);
                break;
            case 'b':
                System.out.print("Enter book ID: ");
                String id = scanner.nextLine();
                searchById(id);
                break;
            case 'c':
                System.out.print("Enter author name: ");
                String author = scanner.nextLine();
                searchByAuthor(author);
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }

    private static void searchByName(String name) {
        for (Book book : books) {
            if (book.name.equalsIgnoreCase(name)) {
                book.displayBook();
                return;
            }
        }
        System.out.println("No book found with name: " + name);
    }

    private static void searchById(String id) {
        for (Book book : books) {
            if (book.id.equalsIgnoreCase(id)) {
                book.displayBook();
                return;
            }
        }
        System.out.println("No book found with ID: " + id);
    }

    private static void searchByAuthor(String author) {
        for (Book book : books) {
            if (book.author.equalsIgnoreCase(author)) {
                book.displayBook();
                return;
            }
        }
        System.out.println("No book found with author: " + author);
    }

    private static void updateBook() {
        System.out.print("Enter the name of the book to update: ");
        String name = scanner.nextLine();

        for (Book book : books) {
            if (book.name.equalsIgnoreCase(name)) {
                System.out.println("Enter new details for the book:");

                System.out.print("Name: ");
                book.name = scanner.nextLine();

                System.out.print("ID: ");
                book.id = scanner.nextLine();

                System.out.print("Author: ");
                book.author = scanner.nextLine();

                System.out.print("Price: ");
                book.price = scanner.nextDouble();

                System.out.print("Rating: ");
                book.rating = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                System.out.println("Book updated successfully!");
                return;
            }
        }

        System.out.println("Book not found!");
    }

    private static void removeBook() {
        System.out.print("Enter the name of the book to remove: ");
        String name = scanner.nextLine();

        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).name.equalsIgnoreCase(name)) {
                books.remove(i);
                System.out.println("Book removed successfully!");
                return;
            }
        }

        System.out.println("Book not found!");
    }
}

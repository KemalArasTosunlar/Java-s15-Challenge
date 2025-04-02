package LibrarySystem.main;

import LibrarySystem.models.*;

public class LibrarySystem {
    public static void main(String[] args) {
        Library library = new Library();
        Librarian librarian = new Librarian("Alice", "securePass");
        Reader reader = new Reader("Bob");
        Author author = new Author("John Doe");


        Book book1 = new Book("Java Programming", "John Doe", 29.99, "Available", "1st Edition", "2023-01-01");
        Book book2 = new Book("Python Basics", "Jane Smith", 19.99, "Available", "2nd Edition", "2022-05-15");
        Book book3 = new Book("Data Structures in Java", "John Doe", 39.99, "Available", "3rd Edition", "2023-03-20"); // Aynı yazardan bir kitap daha
        Book book4 = new Book("Algorithms", "Thomas H. Cormen", 49.99, "Available", "4th Edition", "2022-11-01");
        Book book6 = new Book("Refactoring", "Martin Fowler", 42.50, "Available", "2nd Edition", "2023-09-01"); // book6 tanımlandı

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book6); // book6 kütüphaneye eklendi
        library.addReader(reader);

        System.out.println("\nAttempting to borrow multiple books:");
        librarian.issueBook(reader, book1, library);
        librarian.issueBook(reader, book2, library);
        librarian.issueBook(reader, book3, library);
        librarian.issueBook(reader, book4, library);


        System.out.println("\nReader's borrowed books:");
        reader.displayBorrowedBooks();

        System.out.println("\nReturning one book:");
        librarian.returnBook(reader, book1, library);

        System.out.println("\nReader's borrowed books after return:");
        reader.displayBorrowedBooks();

        System.out.println("\nAttempting to borrow one more book after returning:");
        librarian.issueBook(reader, book6, library);

        System.out.println("\nReader's borrowed books after second attempt:");
        reader.displayBorrowedBooks();
    }
}
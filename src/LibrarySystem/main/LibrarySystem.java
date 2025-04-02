package LibrarySystem.main;

import LibrarySystem.models.*;

public class LibrarySystem {
    public static void main(String[] args) {
        Library library = new Library();
        Librarian librarian = new Librarian("Alice", "securePass");
        Reader reader = new Reader("Bob");
        Author author = new Author("John Doe");

        Book book1 = new Book(1, "Java Programming", "John Doe", 29.99, "Available", "1st Edition", "2023-01-01");
        author.addBook(book1);
        library.addBook(book1);
        library.addReader(reader);

        librarian.issueBook(reader, book1);

        System.out.println("After issuing the book:");
        book1.display();

        librarian.returnBook(reader, book1);
        System.out.println("After returning the book:");
        book1.display();
    }
}

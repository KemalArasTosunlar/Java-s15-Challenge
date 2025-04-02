package LibrarySystem.main;

import java.util.ArrayList;
import java.util.List;

// Base class: Person
abstract class Person {
    protected String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void whoYouAre();
}

// Book class
class Book {
    private int bookID;
    private String name;
    private String author;
    private double price;
    private String status;
    private String edition;
    private String dateOfPurchase;

    public Book(int bookID, String name, String author, double price, String status, String edition, String dateOfPurchase) {
        this.bookID = bookID;
        this.name = name;
        this.author = author;
        this.price = price;
        this.status = status;
        this.edition = edition;
        this.dateOfPurchase = dateOfPurchase;
    }

    public String getTitle() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public void changeOwner(String newOwner) {
        this.status = "Owned by " + newOwner;
    }

    public void display() {
        System.out.println("Book: " + name + " by " + author + " | Status: " + status);
    }
}

// Author class
class Author extends Person {
    private List<Book> books;

    public Author(String name) {
        super(name);
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void whoYouAre() {
        System.out.println("I am an Author: " + name);
    }
}

// Reader class
class Reader extends Person {
    private List<Book> books;

    public Reader(String name) {
        super(name);
        this.books = new ArrayList<>();
    }

    public void purchaseBook(Book book) {
        books.add(book);
        book.changeOwner(this.name);
    }

    public void borrowBook(Book book) {
        books.add(book);
    }

    public void returnBook(Book book) {
        books.remove(book);
    }

    public void whoYouAre() {
        System.out.println("I am a Reader: " + name);
    }
}

// Librarian class
class Librarian extends Person {
    private String password;

    public Librarian(String name, String password) {
        super(name);
        this.password = password;
    }

    public void issueBook(Reader reader, Book book) {
        reader.borrowBook(book);
    }

    public void returnBook(Reader reader, Book book) {
        reader.returnBook(book);
    }

    public void whoYouAre() {
        System.out.println("I am a Librarian: " + name);
    }
}

// Library class
class Library {
    private List<Book> books;
    private List<Reader> readers;

    public Library() {
        this.books = new ArrayList<>();
        this.readers = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addReader(Reader reader) {
        readers.add(reader);
    }

    public void lendBook(Reader reader, Book book) {
        if (books.contains(book)) {
            books.remove(book);
            reader.borrowBook(book);
        }
    }
}

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

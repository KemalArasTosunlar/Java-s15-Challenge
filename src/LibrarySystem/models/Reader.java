package LibrarySystem.models;

import java.util.ArrayList;
import java.util.List;

public class Reader extends Person {
    private List<Book> borrowedBooks;
    private List<Book> ownedBooks;

    public Reader(String name) {
        super(name);
        this.borrowedBooks = new ArrayList<>();
        this.ownedBooks = new ArrayList<>();
    }

    @Override
    public void whoYouAre() {
        System.out.println("I am a Reader: " + name);
    }

    public void purchaseBook(Book book) {
        this.ownedBooks.add(book);
        book.changeOwner(this.name);
        System.out.println(name + " purchased the book: " + book.getTitle() + " (ID: " + book.getBookID() + ")");
    }

    public void borrowBook(Book book) {
        this.borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        this.borrowedBooks.remove(book);
    }

    public boolean hasBorrowedBook(Book book) {
        return this.borrowedBooks.contains(book);
    }

    public boolean hasOwnedBook(Book book) {
        return this.ownedBooks.contains(book);
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public List<Book> getOwnedBooks() {
        return ownedBooks;
    }

    public void displayBorrowedBooks() {
        System.out.println(name + "'s Borrowed Books:");
        if (borrowedBooks.isEmpty()) {
            System.out.println("No books borrowed yet.");
            return;
        }
        for (Book book : borrowedBooks) {
            book.display();
        }
    }

    public void displayOwnedBooks() {
        System.out.println(name + "'s Owned Books:");
        if (ownedBooks.isEmpty()) {
            System.out.println("No books owned yet.");
            return;
        }
        for (Book book : ownedBooks) {
            book.display();
        }
    }
}
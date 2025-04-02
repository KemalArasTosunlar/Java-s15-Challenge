package LibrarySystem.models;

import java.util.ArrayList;
import java.util.List;

public class Reader extends Person {
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

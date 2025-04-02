package LibrarySystem.models;
import LibrarySystem.models.Book;
import LibrarySystem.models.Person;

import java.util.ArrayList;
import java.util.List;

public class Reader extends Person {
    private List<Book> books;

    public Reader(String name) {
        super(name);
        this.books = new ArrayList<>();
    }

    @Override
    public void whoYouAre() {

    }

    public void purchaseBook(Book book) {
        books.add(book);
        book.changeOwner(this.name);
        System.out.println(name + " purchased the book: " + book.getTitle());
    }

    public void borrowBook(Book book) {
        books.add(book);
    }

    public void returnBook(Book book) {
        books.remove(book);
    }

    public boolean hasBook(Book book) {
        return books.contains(book);
    }

    // Yeni Özellik: Okuyucunun kitaplarını listeleme
    public void displayBooks() {
        System.out.println(name + "'s Books:");
        for (Book book : books) {
            book.display();
        }
    }
}

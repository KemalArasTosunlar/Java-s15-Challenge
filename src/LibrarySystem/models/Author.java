package LibrarySystem.models;

import java.util.ArrayList;
import java.util.List;

public class Author extends Person {
    private String biography;
    private List<Book> books;

    public Author(String name, String biography) {
        super(name);
        this.biography = biography;
        this.books = new ArrayList<>();
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    @Override
    public void whoYouAre() {
        System.out.println("I am an Author: " + name);
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", biography='" + biography + '\'' +
                '}';
    }
}
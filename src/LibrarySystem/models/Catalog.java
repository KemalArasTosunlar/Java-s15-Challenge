package LibrarySystem.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Catalog {
    private List<Book> books;


    public Catalog() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Kataloğa kitap eklendi: " + book.getTitle());
    }

    public Book searchBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public List<Book> searchBooksByAuthor(String author) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    public void listBooksByCategory(String category) {
        System.out.println(category + " kategorisindeki kitaplar:");
        for (Book book : books) {
            if (book.getCategory().equalsIgnoreCase(category)) {
                System.out.println(book.getTitle() + " - " + book.getAuthor());
            }
        }
    }

    public void updateBook(int bookId, String newTitle, String newAuthor, String newCategory) {
        for (Book book : books) {
            if (book.getId() == bookId) {
                book.setTitle(newTitle);
                book.setAuthor(newAuthor);
                book.setCategory(newCategory);
                System.out.println("Kitap güncellendi: " + book.getTitle());
                return;
            }
        }
        System.out.println("Kitap bulunamadı!");
    }

    public void deleteBook(int bookId) {
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getId() == bookId) {
                iterator.remove();
                System.out.println("Kitap silindi: " + book.getTitle());
                return;
            }
        }
        System.out.println("Kitap bulunamadı!");
    }

    public void displayBooks() {
        System.out.println("Katalogdaki Kitaplar (" + books.size() + " adet):");
        for (Book book : books) {
            book.display();
        }
    }

    // Belirli bir kitabı katalogdan alma (ödünç verme işlemi için)
    public Book getBookById(int bookId) {
        for (Book book : books) {
            if (book.getId() == bookId) {
                return book;
            }
        }
        return null;
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

}
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
        System.out.println("Kataloğa kitap eklendi: " + book.getTitle() + " (ID: " + book.getBookID() + ")");
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
            if (book.getCategory() != null && book.getCategory().equalsIgnoreCase(category)) {
                System.out.println(book.getTitle() + " (ID: " + book.getBookID() + ") - " + book.getAuthor());
            }
        }
    }

    public void updateBook(int bookId, String newEdition, String newPurchaseDate, String newCategory) {
        for (Book book : books) {
            if (book.getBookID() == bookId) {
                if (newEdition != null && !newEdition.isEmpty()) {
                    book.setEdition(newEdition);
                }
                if (newPurchaseDate != null && !newPurchaseDate.isEmpty()) {
                    book.setDateOfPurchase(newPurchaseDate);
                }
                if (newCategory != null && !newCategory.isEmpty()) {
                    book.setCategory(newCategory);
                }
                System.out.println("Kitap (ID: " + bookId + ") bilgileri güncellendi: " + book.getTitle());
                book.display();
                return;
            }
        }
        System.out.println("Kitap (ID: " + bookId + ") bulunamadı!");
    }

    public void deleteBook(int bookId) {
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getBookID() == bookId) {
                iterator.remove();
                System.out.println("Kitap (ID: " + bookId + ") silindi: " + book.getTitle());
                return;
            }
        }
        System.out.println("Kitap (ID: " + bookId + ") bulunamadı!");
    }

    public void displayBooks() {
        System.out.println("Katalogdaki Kitaplar (" + books.size() + " adet):");
        for (Book book : books) {
            book.display();
        }
    }

    public Book getBookById(int bookId) {
        for (Book book : books) {
            if (book.getBookID() == bookId) {
                return book;
            }
        }
        return null;
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public Book searchBookById(int bookId) {
        for (Book book : books) {
            if (book.getBookID() == bookId) {
                return book;
            }
        }
        return null;
    }
}
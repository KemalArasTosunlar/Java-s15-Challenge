package LibrarySystem.models;

import java.util.*;

public class Library {
    private Catalog catalog;
    private MemberDatabase memberDatabase;
    private Map<Book, Reader> borrowedBooks; // Ödünç verilen kitapları takip etmek için Map


    public Library() {
        this.catalog = new Catalog();
        this.memberDatabase = new MemberDatabase();
        this.borrowedBooks = new HashMap<>();
    }

    // Yeni Kitap Ekleme
    public void addBook(Book book) {
        this.catalog.addBook(book);
    }

    // Kütüphaneye Yeni Okuyucu Ekleme
    public void addReader(Reader reader) {
        this.memberDatabase.addReader(reader);
    }

    // Kitap Ödünç Verme
    public void lendBook(Reader reader, Book book) {
        if (isBookAvailable(book)) {
            this.catalog.removeBook(book);
            borrowedBooks.put(book, reader);
            reader.borrowBook(book);
            System.out.println(reader.getName() + " kitabı ödünç aldı: " + book.getTitle());
        } else {
            System.out.println("Kitap şu anda ödünç verilmiş veya mevcut değil!");
        }
    }

    // Kitap Geri Teslim Etme
    public void returnBook(Reader reader, Book book) {
        if (borrowedBooks.containsKey(book) && borrowedBooks.get(book).equals(reader)) {
            reader.returnBook(book);
            this.catalog.addBook(book);
            borrowedBooks.remove(book);
            System.out.println(reader.getName() + " kitabı iade etti: " + book.getTitle());
        } else {
            System.out.println(reader.getName() + " bu kitabı ödünç almamış!");
        }
    }

    // Belirli bir kitabın mevcut olup olmadığını kontrol et
    private boolean isBookAvailable(Book book) {
        return this.catalog.searchBookByTitle(book.getTitle()) != null && !borrowedBooks.containsKey(book);
    }

    // İsme Göre Kitap Arama
    public Book searchBookByTitle(String title) {
        return this.catalog.searchBookByTitle(title);
    }

    // Yazara Göre Kitap Arama
    public List<Book> searchBooksByAuthor(String author) {
        return this.catalog.searchBooksByAuthor(author);
    }

    // Kategoriye Göre Kitap Listeleme
    public void listBooksByCategory(String category) {
        this.catalog.listBooksByCategory(category);
    }

    // Kitap Güncelleme
    public void updateBook(int bookId, String newTitle, String newAuthor, String newCategory) {
        this.catalog.updateBook(bookId, newTitle, newAuthor, newCategory);
    }

    // Kitap Silme
    public void deleteBook(int bookId) {
        this.catalog.deleteBook(bookId);
    }

    // Kütüphanedeki Kitapları Listeleme
    public void displayBooks() {
        this.catalog.displayBooks();
        System.out.println("Ödünçteki Kitaplar (" + borrowedBooks.size() + " adet):");
        for (Book book : borrowedBooks.keySet()) {
            book.display();
        }
    }

    public Reader searchReaderByName(String name) {
        return this.memberDatabase.searchReaderByName(name);
    }

    public Book searchBookById(int bookId) {
        return this.catalog.getBookById(bookId);
    }

}
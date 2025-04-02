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

    // Yeni Kitap Ekleme (aynı kalır)
    public void addBook(Book book) {
        this.catalog.addBook(book);
    }

    // Kütüphaneye Yeni Okuyucu Ekleme (aynı kalır)
    public void addReader(Reader reader) {
        this.memberDatabase.addReader(reader);
    }

    // Kitap Ödünç Verme (aynı kalır)
    public void lendBook(Reader reader, Book book) {
        if (isBookAvailable(book)) {
            this.catalog.removeBook(book);
            borrowedBooks.put(book, reader);
            reader.borrowBook(book);
            System.out.println(reader.getName() + " kitabı ödünç aldı: " + book.getTitle() + " (ID: " + book.getBookID() + ")");
        } else {
            System.out.println("Kitap (ID: " + book.getBookID() + ") şu anda ödünç verilmiş veya mevcut değil!");
        }
    }

    // Kitap Geri Teslim Etme (aynı kalır)
    public void returnBook(Reader reader, Book book) {
        if (borrowedBooks.containsKey(book) && borrowedBooks.get(book).equals(reader)) {
            reader.returnBook(book);
            this.catalog.addBook(book);
            borrowedBooks.remove(book);
            System.out.println(reader.getName() + " kitabı iade etti: " + book.getTitle() + " (ID: " + book.getBookID() + ")");
        } else {
            System.out.println(reader.getName() + " bu kitabı ödünç almamış!");
        }
    }

    // Belirli bir kitabın mevcut olup olmadığını kontrol et (aynı kalır)
    public boolean isBookAvailable(Book book) {
        return this.catalog.searchBookById(book.getBookID()) != null && !borrowedBooks.containsKey(book);
    }

    // İsme Göre Kitap Arama (aynı kalır)
    public Book searchBookByTitle(String title) {
        return this.catalog.searchBookByTitle(title);
    }

    // Yazara Göre Kitap Arama (aynı kalır)
    public List<Book> searchBooksByAuthor(String author) {
        return this.catalog.searchBooksByAuthor(author);
    }

    // Kategoriye Göre Kitap Listeleme (aynı kalır)
    public void listBooksByCategory(String category) {
        this.catalog.listBooksByCategory(category);
    }

    // Kitap Güncelleme
    public void updateBook(int bookId, String newEdition, String newPurchaseDate, String newCategory) {
        this.catalog.updateBook(bookId, newEdition, newPurchaseDate, newCategory);
    }

    // Kitap Silme (aynı kalır)
    public void deleteBook(int bookId) {
        this.catalog.deleteBook(bookId);
    }

    // Kütüphanedeki Kitapları Listeleme (aynı kalır)
    public void displayBooks() {
        this.catalog.displayBooks();
        System.out.println("Ödünçteki Kitaplar (" + borrowedBooks.size() + " adet):");
        for (Map.Entry<Book, Reader> entry : borrowedBooks.entrySet()) {
            entry.getKey().display();
            System.out.println("  - Ödünç Alan: " + entry.getValue().getName());
        }
    }

    // ID'ye göre kitap arama (aynı kalır)
    public Book searchBookById(int bookId) {
        return this.catalog.searchBookById(bookId);
    }

    public Reader searchReaderByName(String name) {
        return this.memberDatabase.searchReaderByName(name);
    }
    public void listUniqueAuthors() {
        Set<String> authors = new HashSet<>();
        for (Book book : catalog.displayAllBooksForUniqueAuthor()) { // Catalog'dan tüm kitapları alıyoruz
            authors.add(book.getAuthor());
        }

        System.out.println("\nKütüphanedeki Benzersiz Yazarlar:");
        if (authors.isEmpty()) {
            System.out.println("Kütüphanede henüz kitap bulunmamaktadır.");
            return;
        }
        for (String author : authors) {
            System.out.println("- " + author);
        }
    }

    public Catalog getCatalog() {
        return catalog;
    }
}
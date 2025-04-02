package LibrarySystem.models;

import java.util.*;

public class Library {
    private Catalog catalog;
    private MemberDatabase memberDatabase;
    private Map<Book, Reader> borrowedBooks;

    public Library() {
        this.catalog = new Catalog();
        this.memberDatabase = new MemberDatabase();
        this.borrowedBooks = new HashMap<>();
    }

    // Yeni Kitap Ekleme
    public void addBook(Book book) {
        this.catalog.addBook(book);
    }

    // Kütüphaneye Yeni Üye Ekleme
    public void addMember(MemberRecord member) {
        this.memberDatabase.addMember(member);
    }

    // İsme Göre Üye Arama
    public MemberRecord searchMemberByName(String name) {
        return this.memberDatabase.searchMemberByName(name);
    }

    //ID'ye Göre Üye Arama
    public MemberRecord searchMemberById(int memberId) {
        return this.memberDatabase.searchMemberById(memberId);
    }

    //Kitap ödünç verme
    public void lendBook(Reader reader, Book book) {
        MemberRecord member = searchMemberByName(reader.getName());
        if (member != null && member.getNoOfBooksIssued() < member.getMaxBookLimit()) {
            this.catalog.removeBook(book);
            borrowedBooks.put(book, reader);
            member.incBookIssued(); // Ödünç alınan kitap sayısını artır
            System.out.println(reader.getName() + " adlı kullanıcı, " + book.getTitle() + " (ID: " + book.getBookID() + ") adlı kitabı ödünç aldı. (Üye ID: " + member.getMemberId() + ")");
        } else {
            System.out.println(reader.getName() + " adlı kullanıcının kitap ödünç alma limiti dolmuştur veya üye kaydı bulunamadı.");
        }
    }

    //Kitap geri teslim etme
    public void returnBook(Reader reader, Book book) {
        MemberRecord member = searchMemberByName(reader.getName());
        if (member != null && borrowedBooks.containsKey(book) && borrowedBooks.get(book).equals(reader)) {
            reader.returnBook(book);
            this.catalog.addBook(book);
            borrowedBooks.remove(book);
            member.decBookIssued(); // İade edilen kitap sayısını azalt
            System.out.println(reader.getName() + " adlı kullanıcı, " + book.getTitle() + " (ID: " + book.getBookID() + ") adlı kitabı iade etti. (Üye ID: " + member.getMemberId() + ")");
        } else {
            System.out.println(reader.getName() + " adlı kullanıcı bu kitabı ödünç almamış veya üye kaydı bulunamadı.");
        }
    }

    // Belirli bir kitabın mevcut olup olmadığını kontrol et
    private boolean isBookAvailable(Book book) {
        return this.catalog.searchBookById(book.getBookID()) != null && !borrowedBooks.containsKey(book);
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
    public void updateBook(int bookId, String newEdition, String newPurchaseDate, String newCategory) {
        this.catalog.updateBook(bookId, newEdition, newPurchaseDate, newCategory);
    }

    // Kitap Silme
    public void deleteBook(int bookId) {
        this.catalog.deleteBook(bookId);
    }

    // Kütüphanedeki Kitapları Listeleme
    public void displayBooks() {
        this.catalog.displayBooks();
        System.out.println("Ödünçteki Kitaplar (" + borrowedBooks.size() + " adet):");
        for (Map.Entry<Book, Reader> entry : borrowedBooks.entrySet()) {
            entry.getKey().display();
            System.out.println("  - Ödünç Alan: " + entry.getValue().getName());
        }
    }

    // ID'ye göre kitap arama
    public Book searchBookById(int bookId) {
        return this.catalog.searchBookById(bookId);
    }

    public Catalog getCatalog() {
        return catalog;
    }
}
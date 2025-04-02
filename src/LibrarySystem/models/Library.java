package LibrarySystem.models;

import LibrarySystem.models.Book;
import LibrarySystem.models.Reader;


import java.util.*;

 public class Library {
    private List<Book> books;  // Kütüphanedeki mevcut kitaplar
    private List<Reader> readers;  // Kütüphane üyeleri
    private List<Book> borrowedBooks;  // Ödünç verilen kitaplar

    public Library() {
        this.books = new ArrayList<>();
        this.readers = new ArrayList<>();
        this.borrowedBooks = new ArrayList<>();
    }

    // Yeni Kitap Ekleme
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Kitap eklendi: " + book.getTitle());
    }

    // Kütüphaneye Yeni Okuyucu Ekleme
    public void addReader(Reader reader) {
        readers.add(reader);
        System.out.println("Okuyucu eklendi: " + reader.getName());
    }

    // Kitap Ödünç Verme
    public void lendBook(Reader reader, Book book) {
        if (isBookAvailable(book)) {
            books.remove(book);
            borrowedBooks.add(book);
            reader.borrowBook(book);
            System.out.println(reader.getName() + " kitabı ödünç aldı: " + book.getTitle());
        } else {
            System.out.println("Kitap şu anda ödünç verilmiş veya mevcut değil!");
        }
    }

    // Kitap Geri Teslim Etme
    public void returnBook(Reader reader, Book book) {
        if (reader.hasBook(book)) {
            reader.returnBook(book);
            books.add(book);
            borrowedBooks.remove(book);
            System.out.println(reader.getName() + " kitabı iade etti: " + book.getTitle());
        } else {
            System.out.println(reader.getName() + " bu kitaba sahip değil!");
        }
    }

    // Belirli bir kitabın mevcut olup olmadığını kontrol et
    private boolean isBookAvailable(Book book) {
        return books.contains(book) && !borrowedBooks.contains(book);
    }

    // İsme Göre Kitap Arama
    public Book searchBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    // Yazara Göre Kitap Arama
    public List<Book> searchBooksByAuthor(String author) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    // Kategoriye Göre Kitap Listeleme
    public void listBooksByCategory(String category) {
        System.out.println(category + " kategorisindeki kitaplar:");
        for (Book book : books) {
            if (book.getCategory().equalsIgnoreCase(category)) {
                System.out.println(book.getTitle() + " - " + book.getAuthor());
            }
        }
    }

    // Kitap Güncelleme
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

    // Kitap Silme
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

    // Kütüphanedeki Kitapları Listeleme
    public void displayBooks() {
        System.out.println("Kütüphanedeki Kitaplar (" + books.size() + " adet):");
        for (Book book : books) {
            book.display();
        }
    }
}

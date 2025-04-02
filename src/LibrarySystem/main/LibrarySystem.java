package LibrarySystem.main;

import LibrarySystem.models.*;


public class LibrarySystem {
    public static void main(String[] args) {
        Library library = new Library();
        Librarian librarian = new Librarian("Alice", "securePass");
        Reader reader = new Reader("Bob");
        Author author = new Author("John Doe");

        Book book1 = new Book(1, "Java Programming", "John Doe", 29.99, "Available", "1st Edition", "2023-01-01");
        Book book2 = new Book(2, "Python Basics", "Jane Smith", 19.99, "Available", "2nd Edition", "2022-05-15");

        author.addBook(book1);
        library.addBook(book1);
        library.addBook(book2);
        library.addReader(reader);

        // Kitap Arama Testi
        System.out.println("\nSearching for 'Java Programming':");
        Book foundBook = library.searchBookByTitle("Java Programming");
        if (foundBook != null) {
            foundBook.display();
        } else {
            System.out.println("Book not found!");
        }

        // Okuyucu kitap ödünç alıyor
        librarian.issueBook(reader, book1);

        // Okuyucunun kitaplarını listeleme
        System.out.println("\nReader's Books After Borrowing:");
        reader.displayBooks();

        // Kütüphanedeki kitapları listeleme
        System.out.println("\nLibrary Books After Lending:");
        library.displayBooks();

        // Okuyucu kitabı iade ediyor
        librarian.returnBook(reader, book1);

        // Kütüphanedeki kitapları tekrar listeleme
        System.out.println("\nLibrary Books After Returning:");
        library.displayBooks();

        // Okuyucu kitap satın alıyor
        reader.purchaseBook(book2);

        // Okuyucunun kitaplarını tekrar listeleme
        System.out.println("\nReader's Books After Purchasing:");
        reader.displayBooks();
    }
}

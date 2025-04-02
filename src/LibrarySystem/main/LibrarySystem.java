package LibrarySystem.main;

import LibrarySystem.models.*;

public class LibrarySystem {
    public static void main(String[] args) {
        Library library = new Library();
        Librarian librarian = new Librarian("Alice", "securePass");
        Reader reader = new Reader("Bob");
        Author author = new Author("John Doe");


        Book book1 = new Book("Java Programming", "John Doe", 29.99, "Available", "1st Edition", "2023-01-01");
        Book book2 = new Book("Python Basics", "Jane Smith", 19.99, "Available", "2nd Edition", "2022-05-15");
        book1.setCategory("Programming");
        book2.setCategory("Programming");

        author.addBook(book1);
        library.addBook(book1);
        library.addBook(book2);
        library.addReader(reader);

        // Kitap Arama Testleri (aynı kalır)
        System.out.println("\nSearching for 'Java Programming' by title:");
        Book foundBookByTitle = library.searchBookByTitle("Java Programming");
        if (foundBookByTitle != null) {
            foundBookByTitle.display();
        } else {
            System.out.println("Book not found!");
        }

        System.out.println("\nSearching for book with ID: " + book1.getBookID() + " by ID:");
        Book foundBookById = library.searchBookById(book1.getBookID());
        if (foundBookById != null) {
            foundBookById.display();
        } else {
            System.out.println("Book not found!");
        }

        // Kitap Güncelleme Testi (kategori de güncelleniyor)
        System.out.println("\nUpdating book with ID: " + book1.getBookID());
        library.updateBook(book1.getBookID(), "2nd Edition", "2023-05-10", "Advanced Programming");

        Book updatedBook = library.searchBookById(book1.getBookID());
        if (updatedBook != null) {
            updatedBook.display();
        }

        // Kategoriye göre kitap listeleme
        System.out.println("\nBooks in 'Programming' category:");
        library.listBooksByCategory("Programming");

        System.out.println("\nBooks in 'Advanced Programming' category:");
        library.listBooksByCategory("Advanced Programming");

        // Kitap Silme Testi (aynı kalır)
        System.out.println("\nDeleting book with ID: " + book2.getBookID());
        library.deleteBook(book2.getBookID());

        System.out.println("\nLibrary Books After Deletion:");
        library.displayBooks();
    }

}
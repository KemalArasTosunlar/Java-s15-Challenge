package LibrarySystem.main;

import LibrarySystem.models.*;

public class LibrarySystem {
    public static void main(String[] args) {
        Library library = new Library();
        Librarian librarian = new Librarian("Alice", "securePass");
        Reader reader = new Reader("Bob");

        // Üye kaydı oluşturuluyor
        MemberRecord member = new MemberRecord(reader, "General", "123 Main St", "555-1234", 3);

        library.addMember(member); // Üye kütüphaneye ekleniyor

        Book book1 = new Book("The Lord of the Rings", "J.R.R. Tolkien", 30.00, "Available", "1st", "2020-01-15");
        Book book2 = new Book("The Hobbit", "J.R.R. Tolkien", 25.00, "Available", "1st", "2018-05-20");
        Book book3 = new Book("The Silmarillion", "J.R.R. Tolkien", 35.00, "Available", "1st", "2022-11-10");
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        System.out.println("\nAttempting to borrow books:");
        librarian.issueBook(reader, book1, library);
        librarian.issueBook(reader, book2, library);
        librarian.issueBook(reader, book3, library);

        System.out.println("\nReader's borrowed books:");
        reader.displayBorrowedBooks();

        System.out.println("\nAttempting to return a book:");
        librarian.returnBook(reader, book1, library);

        System.out.println("\nReader's borrowed books after return:");
        reader.displayBorrowedBooks();

        System.out.println("\nLibrary books after return:");
        library.displayBooks();

        System.out.println("\nAttempting to borrow a fourth book:");
        Book book4 = new Book("The Fellowship of the Ring", "J.R.R. Tolkien", 40.00, "Available", "1st", "1954-07-29");
        library.addBook(book4);
        librarian.issueBook(reader, book4, library); // Limit aşılmaya çalışılıyor

        System.out.println("\nReader's borrowed books after attempting to exceed limit:");
        reader.displayBorrowedBooks();

        System.out.println("\nLibrary books after attempting to exceed limit:");
        library.displayBooks();
    }
}
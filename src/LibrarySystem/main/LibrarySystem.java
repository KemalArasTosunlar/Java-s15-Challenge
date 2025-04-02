package LibrarySystem.main;

import LibrarySystem.models.*;

public class LibrarySystem {
    public static void main(String[] args) {
        Library library = new Library();

        // Yazarlar oluşturuluyor
        Author tolkien = new Author("J.R.R. Tolkien", "English writer, poet, philologist, and academic");
        Author rowling = new Author("J.K. Rowling", "British novelist, philanthropist, film producer, and screenwriter");

        // Kitaplar oluşturuluyor (Yazar nesneleri kullanılarak)
        Book book1 = new Book("The Lord of the Rings", tolkien, 30.00, "Available", "1st", "2020-01-15");
        Book book2 = new Book("Harry Potter and the Sorcerer's Stone", rowling, 25.00, "Available", "1st", "1997-06-26");

        library.addBook(book1);
        library.addBook(book2);

        // Öğrenci oluşturuluyor
        Student student1 = new Student("Ahmet Yılmaz", "2023101001", "Computer Engineering");

        // Üye kaydı oluşturuluyor
        MemberRecord studentMember = new MemberRecord(student1, "Student", "İstanbul", "555-1111", 5);

        // Üye kütüphaneye ekleniyor
        library.addMember(studentMember);

        // Kitap ödünç alma işlemi
        Librarian librarian = new Librarian("Alice", "securePass");
        librarian.issueBook(student1, book1, library);

        // Kitapları listeleme
        System.out.println("\nLibrary Books:");
        library.displayBooks();

        // Yazarları listeleme
        System.out.println("\nUnique Authors in the Library:");
        library.getCatalog().getBooks().stream().map(Book::getAuthor).distinct().forEach(author -> System.out.println("- " + author.getName()));


    }
}
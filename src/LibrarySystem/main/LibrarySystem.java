package LibrarySystem.main;

import LibrarySystem.models.*;

public class LibrarySystem {
    public static void main(String[] args) {
        Library library = new Library();


// Öğrenci ve Öğretim Üyesi nesneleri oluşturuluyor
        Student student1 = new Student("Ahmet Yılmaz", "2023101001", "Computer Engineering");
        Faculty faculty1 = new Faculty("Ayşe Demir", "19780505", "Prof. Dr.");

        // Üye kayıtları oluşturuluyor
        MemberRecord studentMember = new MemberRecord(student1, "Student", "İstanbul", "555-1111", 5);
        MemberRecord facultyMember = new MemberRecord(faculty1, "Faculty", "Ankara", "555-2222", 10);

        // Üyeler kütüphaneye ekleniyor
        library.addMember(studentMember);
        library.addMember(facultyMember);

        // Kitaplar oluşturuluyor
        Book book1 = new Book("Java Programming", "John Doe", 29.99, "Available", "1st Edition", "2023-01-01");
        Book book2 = new Book("Data Structures", "Jane Smith", 34.50, "Available", "2nd Edition", "2022-08-15");
        library.addBook(book1);
        library.addBook(book2);

        // Kitap ödünç alma işlemleri
        Librarian librarian = new Librarian("Alice", "securePass");
        librarian.issueBook(student1, book1, library);
        librarian.issueBook(faculty1, book2, library);

        // Üye bilgilerini yazdırma (toString metodu ile)
        System.out.println("\nStudent Member Record: " + studentMember);
        System.out.println("Faculty Member Record: " + facultyMember);

        //Polymorphism örneği
        student1.whoYouAre();
        faculty1.whoYouAre();
    }

}
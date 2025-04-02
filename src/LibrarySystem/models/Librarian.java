package LibrarySystem.models;

public class Librarian extends Person {
    private String password;


    public Librarian(String name, String password) {
        super(name);
        this.password = password;
    }

    @Override
    public void whoYouAre() {
        System.out.println("I am a Librarian: " + name);
    }

    // Kitap ödünç verme
    public void issueBook(Reader reader, Book book, Library library) {
        library.lendBook(reader, book);
    }

    // Kitap iade etme
    public void returnBook(Reader reader, Book book, Library library) {
        library.returnBook(reader, book);
    }
}
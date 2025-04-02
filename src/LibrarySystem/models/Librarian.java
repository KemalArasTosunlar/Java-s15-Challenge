package LibrarySystem.models;

public class Librarian extends Person {
    private String password;

    public Librarian(String name, String password) {
        super(name);
        this.password = password;
    }

    public void issueBook(Reader reader, Book book) {
        reader.borrowBook(book);
    }

    public void returnBook(Reader reader, Book book) {
        reader.returnBook(book);
    }

    public void whoYouAre() {
        System.out.println("I am a Librarian: " + name);
    }
}

package LibrarySystem.models;

public class Librarian {
    private String name;
    private String password;

    // Yapıcı metod
    public Librarian(String name, String password) {
        this.name = name;
        this.password = password;
    }

    // Kitap ödünç verme
    public void issueBook(Reader reader, Book book) {
        if (book.getStatus().equals("Available")) {
            reader.borrowBook(book);
            book.setStatus("Lent");
            System.out.println(reader.getName() + " borrowed " + book.getTitle());
        } else {
            System.out.println(book.getTitle() + " is not available.");
        }
    }

    // Kitap iade etme
    public void returnBook(Reader reader, Book book) {
        reader.returnBook(book);
        book.setStatus("Available");
        System.out.println(reader.getName() + " returned " + book.getTitle());
    }
}

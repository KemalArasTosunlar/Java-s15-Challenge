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
        if (reader.getBooksBorrowedCount() < reader.getBookLimit()) {
            library.lendBook(reader, book);
            if (library.isBookAvailable(book)) {
                System.out.println("Fatura kesildi: " + reader.getName() + " adlı kullanıcı, " + book.getTitle() + " (ID: " + book.getBookID() + ") adlı kitabı ödünç aldı.");
            }
        } else {
            System.out.println(reader.getName() + " adlı kullanıcının kitap ödünç alma limiti dolmuştur.");
        }
    }

    // Kitap iade etme
    public void returnBook(Reader reader, Book book, Library library) {
        if (reader.hasBorrowedBook(book)) {
            library.returnBook(reader, book);
            System.out.println("İade işlemi gerçekleştirildi: " + reader.getName() + " adlı kullanıcı, " + book.getTitle() + " (ID: " + book.getBookID() + ") adlı kitabı iade etti.");
            // Ücretlendirme olmadığı için iade durumunda herhangi bir ücret iadesi yapılmıyor.
        } else {
            System.out.println(reader.getName() + " adlı kullanıcı bu kitabı ödünç almamış.");
        }
    }

}
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
        MemberRecord member = library.searchMemberByName(reader.getName());
        if (member != null && member.getNoOfBooksIssued() < member.getMaxBookLimit()) {
            library.lendBook(reader, book);
            System.out.println("Fatura kesildi: " + reader.getName() + " adlı kullanıcı, " + book.getTitle() + " (ID: " + book.getBookID() + ") adlı kitabı ödünç aldı.");
        } else {
            System.out.println(reader.getName() + " adlı kullanıcının kitap ödünç alma limiti dolmuştur veya üye kaydı bulunamadı.");
        }
    }

    // Kitap iade etme
    public void returnBook(Reader reader, Book book, Library library) {
        MemberRecord member = library.searchMemberByName(reader.getName());
        if (member != null) {
            library.returnBook(reader, book);
            System.out.println("İade işlemi gerçekleştirildi: " + reader.getName() + " adlı kullanıcı, " + book.getTitle() + " (ID: " + book.getBookID() + ") adlı kitabı iade etti.");
        } else {
            System.out.println(reader.getName() + " adlı kullanıcı üye değil.");
        }
    }
}
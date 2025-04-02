package LibrarySystem.models;
import java.util.ArrayList;
import java.util.List;

public class Reader extends Person {
    private List<Book> borrowedBooks;
    private List<Book> ownedBooks;
    private int bookLimit; // Kitap ödünç alma limiti
    private int booksBorrowedCount; // Şu anda ödünç aldığı kitap sayısı


    public Reader(String name) {
        super(name);
        this.borrowedBooks = new ArrayList<>();
        this.ownedBooks = new ArrayList<>();
        this.bookLimit = 5; // Varsayılan limit 5 olarak ayarlandı
        this.booksBorrowedCount = 0;
    }

    @Override
    public void whoYouAre() {
        System.out.println("I am a Reader: " + name);
    }

    public void purchaseBook(Book book) {
        this.ownedBooks.add(book);
        book.changeOwner(this.name);
        System.out.println(name + " purchased the book: " + book.getTitle() + " (ID: " + book.getBookID() + ")");
    }

    public void borrowBook(Book book) {
        if (booksBorrowedCount < bookLimit) {
            this.borrowedBooks.add(book);
            this.booksBorrowedCount++;
            System.out.println(name + " borrowed the book: " + book.getTitle() + " (ID: " + book.getBookID() + ")");
        } else {
            System.out.println(name + " has reached the borrowing limit (" + bookLimit + " books). Cannot borrow more books.");
        }
    }

    public void returnBook(Book book) {
        if (this.borrowedBooks.remove(book)) {
            this.booksBorrowedCount--;
            System.out.println(name + " returned the book: " + book.getTitle() + " (ID: " + book.getBookID() + ")");
        } else {
            System.out.println(name + " did not borrow this book: " + book.getTitle() + " (ID: " + book.getBookID() + ")");
        }
    }

    public boolean hasBorrowedBook(Book book) {
        return this.borrowedBooks.contains(book);
    }

    public boolean hasOwnedBook(Book book) {
        return this.ownedBooks.contains(book);
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public List<Book> getOwnedBooks() {
        return ownedBooks;
    }

    public int getBookLimit() {
        return bookLimit;
    }

    public void setBookLimit(int bookLimit) {
        this.bookLimit = bookLimit;
    }

    public int getBooksBorrowedCount() {
        return booksBorrowedCount;
    }

    public void displayBorrowedBooks() {
        System.out.println(name + "'s Borrowed Books (" + booksBorrowedCount + "/" + bookLimit + "):");
        if (borrowedBooks.isEmpty()) {
            System.out.println("No books borrowed yet.");
            return;
        }
        for (Book book : borrowedBooks) {
            book.display();
        }
    }

    public void displayOwnedBooks() {
        System.out.println(name + "'s Owned Books:");
        if (ownedBooks.isEmpty()) {
            System.out.println("No books owned yet.");
            return;
        }
        for (Book book : ownedBooks) {
            book.display();
        }
    }
}
package LibrarySystem.models;

public class Book {
    private final String name;
    private final String author;
    private String status;
    private String edition;
    private String dateOfPurchase;
    private Category category;

    // Constructor
    public Book(int bookID, String name, String author, double price, String status, String edition, String dateOfPurchase) {
        this.name = name;
        this.author = author;
        this.status = status;
        this.edition = edition;
        this.dateOfPurchase = dateOfPurchase;
        this.category = category;
    }

    // Getter metotları
    public String getTitle() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Kitap sahibi değiştirme
    public void changeOwner(String newOwner) {
        this.status = "Owned by " + newOwner;
    }

    // Kitap bilgilerini yazdırma
    public void display() {
        System.out.println("Book: " + name + " by " + author + " | Status: " + status);
    }

    public String getCategory() {
        return "";
    }

    public int getId() {
        return 0;
    }

    public void setTitle(String newTitle) {
    }

    public void setAuthor(String newAuthor) {
    }

    public void setCategory(String newCategory) {
    }
}

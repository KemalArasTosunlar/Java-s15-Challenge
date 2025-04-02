package LibrarySystem.models;

public class Book {
    private int bookID;
    private String name;
    private String author;
    private double price;
    private String status;
    private String edition;
    private String dateOfPurchase;

    public Book(int bookID, String name, String author, double price, String status, String edition, String dateOfPurchase) {
        this.bookID = bookID;
        this.name = name;
        this.author = author;
        this.price = price;
        this.status = status;
        this.edition = edition;
        this.dateOfPurchase = dateOfPurchase;
    }

    public String getTitle() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public void changeOwner(String newOwner) {
        this.status = "Owned by " + newOwner;
    }

    public void display() {
        System.out.println("Book: " + name + " by " + author + " | Status: " + status);
    }
}

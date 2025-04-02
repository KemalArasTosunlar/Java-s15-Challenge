package LibrarySystem.models;

public class Book {
    private final int bookID; // ID artık sadece constructor'da atanacak
    private final String name;
    private final String author;
    private String status;
    private String edition;
    private String dateOfPurchase;
    private Category category;
    private static int nextBookID = 1; // Statik sayaç


// Constructor (aynı kalır)

    public Book(String name, String author, double price, String status, String edition, String dateOfPurchase) {
        this.bookID = nextBookID++;
        this.name = name;
        this.author = author;
        this.status = status;
        this.edition = edition;
        this.dateOfPurchase = dateOfPurchase;
        this.category = null;
    }

    public int getBookID() {
        return bookID;
    }

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

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(String dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(String newCategoryName) {
        this.category = new Category(newCategoryName);
    }

    public void display() {
        System.out.println("Book ID: " + bookID + " | Book: " + name + " by " + author +
                " | Status: " + status + " | Edition: " + edition +
                " | Purchase Date: " + dateOfPurchase +
                (category != null ? " | Category: " + category : "")); // toString metodu kullanılır
    }

    public void setTitle(String newTitle) {
        throw new UnsupportedOperationException("Book title cannot be changed after creation.");
    }

    public void setAuthor(String newAuthor) {
        throw new UnsupportedOperationException("Book author cannot be changed after creation.");
    }

    public void changeOwner(String name) {
    }
}
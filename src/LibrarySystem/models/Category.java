package LibrarySystem.models;

public class Category {
    private String name;

    public Category(String name) {
        this.name = name.trim(); // Başında ve sonunda boşlukları temizle
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.trim();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Category category = (Category) obj;
        return name.equalsIgnoreCase(category.name); // Büyük/küçük harf duyarsız karşılaştırma
    }

    @Override
    public int hashCode() {
        return name.toLowerCase().hashCode();
    }

    @Override
    public String toString() {
        return name;
    }
}

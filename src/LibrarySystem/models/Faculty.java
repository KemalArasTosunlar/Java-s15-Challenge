package LibrarySystem.models;

public class Faculty extends Reader {
    private String employeeId;
    private String title; // Örneğin: Prof. Dr., Doç. Dr., Arş. Gör.


    public Faculty(String name, String employeeId, String title) {
        super(name);
        this.employeeId = employeeId;
        this.title = title;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void whoYouAre() {
        System.out.println("I am Faculty: " + name + ", Employee ID: " + employeeId + ", Title: " + title);
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "name='" + getName() + '\'' +
                ", employeeId='" + employeeId + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

}
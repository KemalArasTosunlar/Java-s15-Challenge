package LibrarySystem.models;

public class Student extends Reader {
    private String studentId;
    private String department;


    public Student(String name, String studentId, String department) {
        super(name);
        this.studentId = studentId;
        this.department = department;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public void whoYouAre() {
        System.out.println("I am a Student: " + name + ", Student ID: " + studentId + ", Department: " + department);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + getName() + '\'' +
                ", studentId='" + studentId + '\'' +
                ", department='" + department + '\'' +
                '}';
    }

}
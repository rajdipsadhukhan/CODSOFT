public class Student {
    private int rollNumber;
    private String name;
    private String grade;
    private String contact;

    public Student(int rollNumber, String name, String grade, String contact) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.grade = grade;
        this.contact = contact;
    }

    public int getRollNumber() { return rollNumber; }
    public String getName() { return name; }
    public String getGrade() { return grade; }
    public String getContact() { return contact; }

    public void display() {
        System.out.printf("%-10d %-20s %-10s %-15s%n",
                rollNumber, name, grade, contact);
    }
}

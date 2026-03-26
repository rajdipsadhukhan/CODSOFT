import java.sql.*;
import java.util.Scanner;


public class StudentManagementSystem {
    private static final String url = "put database url";
    private static final String username = "put username";
    private static final String password = "put password";


    // Add student
    public static void addStudent(Connection con, Scanner sc) {
        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter roll number: ");
        int roll = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter grade: ");
        String grade = sc.nextLine();

        System.out.print("Enter contact: ");
        String contact = sc.nextLine();

        Student s = new Student(roll, name, grade, contact);

        String query = "INSERT INTO students VALUES (" +
                s.getRollNumber() + ", '" +
                s.getName() + "', '" +
                s.getGrade() + "', '" +
                s.getContact() + "')";

        try (Statement stmt = con.createStatement()) {
            int rows = stmt.executeUpdate(query);
            if(rows> 0){
                System.out.println("Student added successfully");
            }
            else{
                System.out.println("Failed!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //  view students
    public static void viewStudents(Connection con) {
        String query = "SELECT * FROM students";

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("\nSTUDENT LIST:");
            System.out.println("-------------------------------------------------------------");
            System.out.printf("%-10s %-20s %-10s %-15s%n",
                    "Roll", "Name", "Grade", "Contact");
            System.out.println("-------------------------------------------------------------");

            while (rs.next()) {
                Student s = new Student(
                        rs.getInt("roll_number"),
                        rs.getString("name"),
                        rs.getString("grade"),
                        rs.getString("contact")
                );
                s.display();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // search student
    public static void searchStudent(Connection con, Scanner sc) {
        System.out.print("Enter roll number: ");
        int roll = sc.nextInt();
        sc.nextLine();

        String query = "SELECT * FROM students WHERE roll_number = " + roll;

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                Student s = new Student(
                        rs.getInt("roll_number"),
                        rs.getString("name"),
                        rs.getString("grade"),
                        rs.getString("contact")
                );

                System.out.println("Student Found:");
                s.display();
            } else {
                System.out.println("Student not found!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // update student
    public static void updateStudent(Connection con, Scanner sc) {
        try {
            System.out.print("Enter roll number to update: ");
            int roll = sc.nextInt();
            sc.nextLine();

            if (!studentExists(con, roll)) {
                System.out.println("Student not found!");
                return;
            }

            System.out.print("Enter new name: ");
            String name = sc.nextLine();

            System.out.print("Enter new grade: ");
            String grade = sc.nextLine();

            System.out.print("Enter new contact: ");
            String contact = sc.nextLine();

            String query = "UPDATE students SET name = '" + name +
                    "', grade = '" + grade +
                    "', contact = '" + contact +
                    "' WHERE roll_number = " + roll;

            Statement stmt = con.createStatement();
            int rows = stmt.executeUpdate(query);

            if(rows > 0){
                System.out.println("Student details updated");
            }
            else{
                System.out.println("Updation failed");
            }


            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // checking is student details exists or not
    public static boolean studentExists(Connection con, int roll) {
        String query = "SELECT * FROM students WHERE roll_number = " + roll;

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            boolean exists = rs.next();

            rs.close();
            stmt.close();

            return exists;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // delete student
    public static void deleteStudent(Connection con, Scanner sc) {
        try {
            System.out.print("Enter roll number to delete: ");
            int roll = sc.nextInt();
            sc.nextLine();

            if (!studentExists(con, roll)) {
                System.out.println("Student not found!");
                return;
            }

            String query = "DELETE FROM students WHERE roll_number = " + roll;

            Statement stmt = con.createStatement();
            int rows = stmt.executeUpdate(query);
            if(rows > 0){
                System.out.println("Student details Deleted");
            }else{
                System.out.println("Deletion failed");
            }


            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void exit() {
        System.out.println("\n====== Thank You for using this Student Management System ======");
        System.exit(0);
    }

    public static void mainInterface(Scanner sc) throws Exception{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try {
            Connection con = DriverManager.getConnection(url, username, password);

            int option = 0;

            while (option != 6) {
                System.out.println();
                System.out.println("Student Management System");
                System.out.println("1. Add Student");
                System.out.println("2. View Students");
                System.out.println("3. Search Student");
                System.out.println("4. Update Student");
                System.out.println("5. Delete Student");
                System.out.println("6. Exit");

                System.out.println("Select an option:");
                option = sc.nextInt();

                switch (option) {
                    case 1:
                        sc.nextLine();
                        addStudent(con, sc);
                        break;
                    case 2:
                        viewStudents(con);
                        break;
                    case 3:

                        searchStudent(con, sc);
                        break;
                    case 4:

                        updateStudent(con, sc);
                        break;
                    case 5:

                        deleteStudent(con, sc);
                        break;
                    case 6:
                        exit();
                        sc.close();
                        return;
                    default:
                        System.out.println("Choose a valid option");
                }
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(RuntimeException ex){
            throw new RuntimeException(ex);
        }



    }
    public static void main(String[] args) throws Exception {
            Scanner sc = new Scanner(System.in);
            mainInterface(sc);
    }


}

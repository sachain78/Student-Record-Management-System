import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int id;
    String name;
    int age;
    String grade;

    public Student(int id, String name, int age, String grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String toString() {
        return id + " | " + name + " | " + age + " | " + grade;
    }
}

public class StudentManagement {
    static ArrayList<Student> students = new ArrayList<>();
    static int nextId = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Student Record Management ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {
                case 1 -> addStudent(scanner);
                case 2 -> viewStudents();
                case 3 -> updateStudent(scanner);
                case 4 -> deleteStudent(scanner);
                case 5 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 5);
    }

    public static void addStudent(Scanner scanner) {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // clear buffer
        System.out.print("Enter grade: ");
        String grade = scanner.nextLine();

        students.add(new Student(nextId++, name, age, grade));
        System.out.println("Student added.");
    }

    public static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        System.out.println("\nID | Name | Age | Grade");
        for (Student s : students) {
            System.out.println(s);
        }
    }

    public static void updateStudent(Scanner scanner) {
        viewStudents();
        System.out.print("Enter student ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // clear buffer
        Student student = findStudentById(id);
        if (student != null) {
            System.out.print("Enter new name: ");
            student.name = scanner.nextLine();
            System.out.print("Enter new age: ");
            student.age = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter new grade: ");
            student.grade = scanner.nextLine();
            System.out.println("Student updated.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public static void deleteStudent(Scanner scanner) {
        viewStudents();
        System.out.print("Enter student ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // clear buffer
        Student student = findStudentById(id);
        if (student != null) {
            students.remove(student);
            System.out.println("Student deleted.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public static Student findStudentById(int id) {
        for (Student s : students) {
            if (s.id == id) {
                return s;
            }
        }
        return null;
    }
}

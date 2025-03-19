import java.util.Scanner;

class Student {
    // Attributes
    String name;
    int age;
    int[] marks = new int[3]; // Marks for 3 subjects

    // Constructor to initialize student details
    Student(String name, int age, int[] marks) {
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    // Method to display student details
    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Marks: " + marks[0] + ", " + marks[1] + ", " + marks[2]);
        int total = marks[0] + marks[1] + marks[2];
        double average = total / 3.0;
        System.out.println("Average Marks: " + average);

        // Ternary operator to determine if the student passed or failed
        String result = (average >= 40) ? "PASS" : "FAIL";
        System.out.println("Result: " + result);
        System.out.println("------------------------");
    }
}

public class StudentManagement {
    static Scanner sc = new Scanner(System.in);
    static Student[] students = new Student[100]; // Array to store students
    static int count = 0; // Number of students added

    // Method to add a new student
    static void addStudent() {
        System.out.print("Enter student name: ");
        String name = sc.next();

        int age = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println("Enter student age: ");
                age = sc.nextInt();
                validInput = true;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid integer for age.");
                sc.nextLine(); // Clear the buffer
            }
        }

        int[] marks = new int[3];
        System.out.print("Enter marks for 3 subjects: ");
        for (int i = 0; i < 3; i++) {
            validInput = false;
            while (!validInput) {
                try {
                    System.out.println("Enter marks for subject " + (i + 1) + ": ");
                    marks[i] = sc.nextInt(); // Read marks
                    validInput = true;
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Invalid input! Please enter a valid integer for marks.");
                    sc.nextLine(); // Clear the buffer
                }
            }
        }

        // Creating student object and adding to the array
        students[count] = new Student(name, age, marks);
        count++;

        System.out.println("Student added successfully!\n");
    }

    // Method to display all students
    static void displayStudents() {
        if (count == 0) {
            System.out.println("No students to display!");
            return;
        }

        System.out.println("\n---- Student Details ----");
        for (int i = 0; i < count; i++) {
            students[i].displayInfo(); // Calling the displayInfo method of Student class
        }
    }

    // Method to calculate average marks of all students
    static void calculateAverageMarks() {
        if (count == 0) {
            System.out.println("No students to calculate average!");
            return;
        }

        int totalMarks = 0;
        int totalSubjects = count * 3;

        for (int i = 0; i < count; i++) {
            for (int mark : students[i].marks) {
                totalMarks += mark;
            }
        }

        double average = (double) totalMarks / totalSubjects;
        System.out.printf("Class Average Marks: %.2f\n", average);
    }

    // Method to show menu and perform actions
    static void menu() {
        while (true) {
            System.out.println("\n==== STUDENT MANAGEMENT SYSTEM ====");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Calculate Average Marks");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addStudent(); // Call addStudent method
                    break;
                case 2:
                    displayStudents(); // Call displayStudents method
                    break;
                case 3:
                    calculateAverageMarks(); // Call calculateAverageMarks method
                    break;
                case 4:
                    System.out.println("Exiting the program...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        menu(); // Start the program
    }
}

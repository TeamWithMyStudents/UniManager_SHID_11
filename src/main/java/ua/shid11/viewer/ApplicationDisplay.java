package ua.shid11.viewer;

import ua.shid11.controller.StudentController;
import ua.shid11.controller.TeacherController;

import java.util.Scanner;

public class ApplicationDisplay {
    private static final StudentController studentController = new StudentController();
    private static final TeacherController teacherController = new TeacherController();
    private static final Scanner scanner = new Scanner(System.in);

    public void start() {
        mainMenu();
    }

    private void mainMenu() {
        while (true) {
            System.out.print("""
                    
                    ===== MAIN MENU =====
                    1. Student Management
                    2. Teacher Management
                    0. Exit
                    Enter choice:\s""");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> studentSubMenu();
                case "2" -> teacherSubMenu();
                case "0" -> {
                    System.out.println("Exiting program...");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private void studentSubMenu() {
        while (true) {
            System.out.print("""
                    
                    ---- Student Menu ----
                    1. Add Student
                    2. Show All Students
                    3. Delete Student by ID
                    0. Exit
                    Enter choice:\s""");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> {
                    System.out.print("Enter Student (Name Surname Group): ");
                    String input = scanner.nextLine();
                    String[] parts = input.trim().split("\\s+");

                    if (parts.length < 3) {
                        System.out.println("Required: name, surname, group");
                        continue;
                    }
                    String surname = parts[0];
                    String name = parts[1];
                    String group = parts[parts.length - 1];
                    studentController.create(surname, name, group);

                }
                case "2" -> studentController.printAll();
                case "3" -> {
                    System.out.print("Enter Student ID: ");
                    String input = scanner.nextLine();
                    try {
                        int id = Integer.parseInt(input);
                        studentController.delete(id);
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Student ID must be an integer number!");
                    }

                }
                case "0" -> {
                    return;
                }
                default -> System.out.println("Invalid choice");
            }

        }
    }

    private void teacherSubMenu() {
        while (true) {
            System.out.print("""
                    
                    ---- Teacher Menu ----
                    1. Add Teacher
                    2. Show All Teachers
                    3. Calculate Budget
                    4. Filter by Degree
                    0. Exit
                    Enter choice:\s""");

            String choice = scanner.nextLine();

            switch (choice) {

                case "1" -> {
                    System.out.println("Enter: Name Surname Dept Degree Salary");

                    String[] parts = scanner.nextLine().trim().split("\\s+");

                    if (parts.length != 5) {
                        System.out.println("Required: Name Surname Dept Degree Salary");
                        continue;
                    }

                    String name = parts[0];
                    String surname = parts[1];
                    String dept = parts[2];
                    String degree = parts[3];

                    try {
                        double salary = Double.parseDouble(parts[4]);
                        teacherController.create(name, surname, dept, degree, salary);
                    } catch (NumberFormatException e) {
                        System.out.println("Salary must be a number!");
                    }
                }

                case "2" -> teacherController.printAll();

                case "3" -> {
                    double total = teacherController.calculateTotalSalary();
                    System.out.println("Total salary budget: " + total);
                }

                case "4" -> {
                    System.out.print("Enter degree: ");
                    String degree = scanner.nextLine();
                    teacherController.filterByDegree(degree);
                }

                case "0" -> {
                    return;
                }

                default -> System.out.println("Invalid choice!");
            }
        }
    }
}

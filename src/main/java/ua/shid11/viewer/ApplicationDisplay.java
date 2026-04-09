/**
 * Console-based user interface for the application.
 *
 * <p>This class is responsible for interacting with the user via the console,
 * displaying menus, and delegating user actions to the appropriate controllers.</p>
 *
 * <p>It provides a simple text-based navigation system for managing:
 * <ul>
 *     <li>Students</li>
 *     <li>Teachers</li>
 * </ul>
 *
 * <p>The application runs in a loop and allows users to perform CRUD operations,
 * assign roles, and view aggregated data.</p>
 *
 * <p><b>Features:</b>
 * <ul>
 *     <li>Main menu with navigation to student and teacher submenus</li>
 *     <li>Input validation and basic error handling</li>
 *     <li>Delegation of business logic to controllers</li>
 * </ul>
 *
 * <p><b>Note:</b> This is a console (CLI) application using {@link java.util.Scanner}
 * for input handling.</p>
 */

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
                    4. Assign Starosta
                    5. Assign Deputy
                    0. Exit
                    Enter choice:\s""");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> {
                    System.out.print("Enter Student (Name Surname Group Email Password): ");
                    String input = scanner.nextLine();
                    String[] parts = input.trim().split("\\s+");

                    if (parts.length != 5) {
                        System.out.println("Required: name, surname, group, email, password");
                        continue;
                    }
                    String name = parts[0];
                    String surname = parts[1];
                    String group = parts[2];
                    String email = parts[3];
                    String password = parts[4];
                    studentController.create(name, surname, group, email, password);

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
                case "4" -> {
                    System.out.print("Enter Student ID: ");
                    String input = scanner.nextLine();
                    try {
                        int id = Integer.parseInt(input);
                        studentController.assignStarosta(id);
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Student ID must be an integer number!");
                    }
                }
                case "5" -> {
                    System.out.print("Enter Student ID: ");
                    String input = scanner.nextLine();
                    try {
                        int id = Integer.parseInt(input);
                        studentController.assignDeputy(id);
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
                    System.out.println("Enter: Name Surname Dept Degree Salary Email Password");

                    String[] parts = scanner.nextLine().trim().split("\\s+");

                    if (parts.length != 7) {
                        System.out.println("Required: Name Surname Dept Degree Salary Email Password");
                        continue;
                    }

                    String name = parts[0];
                    String surname = parts[1];
                    String dept = parts[2];
                    String degree = parts[3];
                    String email = parts[5];
                    String password = parts[6];

                    try {
                        double salary = Double.parseDouble(parts[4]);
                        teacherController.create(name, surname, dept, degree, salary, email, password);
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

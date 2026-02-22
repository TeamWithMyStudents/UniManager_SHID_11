package ua.shid11.viewer;

import ua.shid11.controller.StudentController;

import java.util.Scanner;

public class ApplicationDisplay {
    private final StudentController controller = new StudentController();
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("---- Menu Options: ----");
            System.out.println("1. Add Student");
            System.out.println("2. Show All Students");
            System.out.println("3. Delete Student by ID");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter Student (with space): ");
                    String input = scanner.nextLine();
                    controller.create(input);
                    break;
                case "2":
                    controller.printAll();
                    break;
                case "3":
                    System.out.print("Enter Student ID: ");
                    try {
                        int id = Integer.parseInt(scanner.nextLine());
                        controller.delete(id);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid Student ID (ID must be number)");
                    }
                    break;
                case "4":
                    System.out.println("Exit");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

}

package ua.shid11.viewer;

import ua.shid11.controller.StudentController;

import java.util.Scanner;

public class ApplicationDisplay {
    private static final StudentController controller = new StudentController();
    private static final Scanner scanner = new Scanner(System.in);

    public static void start() {
        while (true) {
            System.out.print("""
                    ---- Menu Options: ----
                    1. Add Student
                    2. Show All Students
                    3. Delete Student by ID
                    4. Exit
                    Enter choice:\s""");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> {
                    System.out.print("Enter Student (with space): ");
                    String input = scanner.nextLine();
                    String[] parts = input.trim().split("\\s+");

                    if (parts.length < 3) {
                        System.out.println("Required: surname, name, group");
                    }
                    String surname = parts[1];
                    String name = parts[0];
                    String group = parts[parts.length - 1];
                    controller.create(surname, name, group);

                }
                case "2" -> controller.printAll();
                case "3" -> {
                    System.out.print("Enter Student ID: ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("Invalid Student ID (ID must be number)");
                        scanner.nextLine();
                    }
                    int id = Integer.parseInt(scanner.nextLine());
                    scanner.nextLine();
                    controller.delete(id);

                }
                case "4" -> {
                    System.out.println("Exit");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice");
            }

        }
    }

}

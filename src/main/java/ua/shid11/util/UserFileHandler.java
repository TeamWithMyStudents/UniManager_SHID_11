package ua.shid11.util;

import ua.shid11.model.Teacher;
import ua.shid11.model.User;
import ua.shid11.model.Student;

import java.util.ArrayList;
import java.util.List;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Utility for persisting {@link User} data to a CSV-style text file.
 * Handles serialization and deserialization for {@link Student} and {@link Teacher} types.
 */
public class UserFileHandler {
    private static final String FILE_PATH = "users_db.txt";

    /**
     * Saves a list of users to the file.
     * @param users the list of users to persist
     * @throws RuntimeException if an I/O error occurs during saving
     */
    public static void saveUsers(List<User> users) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (User user : users) {
                String line;

                if (user instanceof Student s) {
                    line = "Student," +
                            s.getName() + "," +
                            s.getSurname() + "," +
                            s.getGroup() + "," +
                            s.getEmail() + "," +
                            s.getPassword();
                } else if (user instanceof Teacher t) {
                    line = "Teacher," +
                            t.getName() + "," +
                            t.getSurname() + "," +
                            t.getDepartment() + "," +
                            t.getDegree() + "," +
                            t.getSalary() + "," +
                            t.getEmail() + "," +
                            t.getPassword();
                } else {
                    System.err.println("Skipping unsupported user type: " + user.getClass().getName());
                    continue;
                }

                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to save users", e);
        }
    }

    /**
     * Loads users from the file and reconstructs objects based on their type.
     * @return a list of loaded {@link User} objects; empty if file is missing
     * @throws RuntimeException if an I/O error occurs during loading
     */
    public static List<User> loadUsers() {
        List<User> users = new ArrayList<>();
        File file = new File(FILE_PATH);

        if (!file.exists()) {
            return users;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length < 2) {
                    System.err.println("Skipping malformed line: " + line);
                    continue;
                }

                String type = data[0];
                String name = data[1];
                String surname = data[2];

                if (type.equals("Student") && data.length >= 6) {
                    String group = data[3];
                    String email = data[4];
                    String password = data[5];
                    users.add(new Student(name, surname, group, email, password));

                } else if (type.equals("Teacher") && data.length >= 8) {
                    String department = data[3];
                    String degree = data[4];
                    double salary;
                    try {
                        salary = Double.parseDouble(data[5]);
                    } catch (NumberFormatException ex) {
                        System.err.println("Skipping invalid teacher salary: " + line);
                        continue;
                    }
                    String email = data[6];
                    String password = data[7];
                    users.add(new Teacher(name, surname, department, degree, salary, email, password));
                } else {
                    System.err.println("Skipping invalid record: " + line);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load users", e);
        }
        return users;
    }
}
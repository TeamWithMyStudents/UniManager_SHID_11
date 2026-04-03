package ua.shid11.util;

import ua.shid11.model.Teacher;
import ua.shid11.model.User;
import ua.shid11.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class UserFileHandler {
    private static final String FILE_PATH = "users_db.txt";

    public static void saveUsers(List<User> users) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (User user : users) {
                String line = "";

                if (user instanceof Student s) {
                    line = "Student," +
                            s.getName() + "," +
                            s.getSurname() + "," +
                            s.getEmail() + "," +
                            s.getPassword() + "," +
                            s.getGroup();
                } else if (user instanceof Teacher t) {
                    line = "Teacher," +
                            t.getName() + "," +
                            t.getSurname() + "," +
                            t.getEmail() + "," +
                            t.getPassword() + "," +
                            t.getDegree();
                }

                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error while saving users: " + e.getMessage());
        }
    }

    public static List<User> loadUsers() {
        List<User> users = new ArrayList<>();
        File file = new File(FILE_PATH);

        if (!file.exists()) { return  users; }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                String type = data[0];
                String name = data[1];
                String surname = data[2];

                if (type.equals("Student")) {
                    String group = data[3];
                    String email = data[4];
                    String password = data[5];
                    users.add(new Student(name, surname, group, email, password));

                } else if (type.equals("Teacher")) {
                    String department = data[3];
                    String degree = data[4];
                    double salary = Double.parseDouble(data[5]);
                    String email = data[6];
                    String password = data[7];
                    users.add(new Teacher(name, surname, department, degree, salary, email, password));
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading users: " + e.getMessage());
        }
        return users;
    }
}

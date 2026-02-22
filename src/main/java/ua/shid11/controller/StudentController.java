package ua.shid11.controller;

import ua.shid11.model.Student;
import ua.shid11.service.UserService;
import ua.shid11.service.impl.StudentServiceImpl;

public class StudentController {
    private final UserService service = new StudentServiceImpl();

    public void create(String input) {
        String[] parts = input.trim().split("\\s+");

        if (parts.length < 3) {
            System.out.println("Required: surname, name, group");
            return;
        }

        Student student = new Student(parts[1], parts[0], parts[parts.length - 1]);
        service.add(student);
        System.out.println("Student created");
    }

    public void delete(int id) {
        service.delete(id);
    }

    public void printAll() {
        for (Object user : service.getAll()) {
            System.out.println(user);
        }
    }
}

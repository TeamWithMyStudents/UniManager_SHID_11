package ua.shid11.controller;

import ua.shid11.model.Student;
import ua.shid11.service.StudentService;
import ua.shid11.service.impl.StudentServiceImpl;

public class StudentController {
    private final StudentService service = new StudentServiceImpl();

    public void create(String name, String surname, String group) {
        Student student = new Student(name, surname, group);
        service.add(student);
        System.out.println("Student created");
    }

    public void delete(int id) {
        service.delete(id);
    }

    public void printAll() {
        for (Student student : service.getAll()) {
            System.out.println(student);
        }
    }
    public void assignStarosta(int id) {
        try {
            service.assignStarosta(id);
        }catch (Exception e) {
            System.out.println("Assign starosta failed" + e.getMessage());
        }
    }
    public void assignDeputy(int id) {
        try {
            service.assignDeputy(id);
        }catch (Exception e) {
            System.out.println("Assign deputy failed" + e.getMessage());
        }
    }
}

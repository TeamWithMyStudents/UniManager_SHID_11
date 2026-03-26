package ua.shid11.controller;

import ua.shid11.model.Teacher;
import ua.shid11.service.TeacherService;
import ua.shid11.service.impl.TeacherServiceImpl;

public class TeacherController {
    private final TeacherService service = new TeacherServiceImpl();

    public void create(String name, String surname, String department, String degree, double salary, String email, String password) {
        Teacher teacher = new Teacher(name, surname, department, degree, salary, email, password);
        service.add(teacher);
    }

    public void delete(int id) {
        service.delete(id);
    }

    public void printAll() {
        for (Teacher teacher : service.getAll()) {
            System.out.println(teacher);
        }
    }

    public double calculateTotalSalary() {
        return service.calculateTotalSalary();
    }

    public void filterByDegree(String degree) {
        service.filterByDegree(degree);
    }
}

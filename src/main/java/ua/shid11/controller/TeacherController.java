package ua.shid11.controller;

import ua.shid11.model.Teacher;
import ua.shid11.security.AuthService;
import ua.shid11.security.AuthServiceImpl;
import ua.shid11.service.TeacherService;
import ua.shid11.service.impl.TeacherServiceImpl;

/**
 * Controller for managing {@link Teacher} operations and registration.
 */
public class TeacherController {
    private final TeacherService service = new TeacherServiceImpl();
    private final AuthService authService = new AuthServiceImpl();

    /**
     * Registers a teacher in the auth system and adds them to the service.
     */
    public void create(String name, String surname, String department, String degree, double salary, String email, String password) {
        Teacher teacher = new Teacher(name, surname, department, degree, salary, email, password);
        authService.register(teacher);
        service.add(teacher);
        System.out.println("Teacher created");
    }

    /**
     * Removes a teacher by their unique ID.
     */
    public void delete(int id) {
        service.delete(id);
    }

    /**
     * Prints all teachers to the console.
     */
    public void printAll() {
        service.getAll()
                .forEach(System.out::println);
    }

    /**
     * @return the sum of all teachers' salaries.
     */
    public double calculateTotalSalary() {
        return service.calculateTotalSalary();
    }

    /**
     * Displays teachers filtered by their academic degree.
     */
    public void filterByDegree(String degree) {
        service.filterByDegree(degree);
    }
}

/**
 * Controller class for managing Teacher-related operations.
 *
 * <p>This class serves as a bridge between the user interface and
 * the business logic layers (TeacherService and AuthService).</p>
 *
 * <p>Provides functionality to:
 * <ul>
 *     <li>Create and register new teachers</li>
 *     <li>Delete teachers by ID</li>
 *     <li>Display all teachers</li>
 *     <li>Calculate total salary of all teachers</li>
 *     <li>Filter teachers by academic degree</li>
 * </ul>
 *
 * <p><b>Note:</b>
 * Teacher creation includes both registration in the authentication system
 * and addition to the teacher service.</p>
 */

package ua.shid11.controller;

import ua.shid11.model.Teacher;
import ua.shid11.security.AuthService;
import ua.shid11.security.AuthServiceImpl;
import ua.shid11.service.TeacherService;
import ua.shid11.service.impl.TeacherServiceImpl;

public class TeacherController {
    private final TeacherService service = new TeacherServiceImpl();
    private final AuthService authService = new AuthServiceImpl();

    public void create(String name, String surname, String department, String degree, double salary, String email, String password) {
        Teacher teacher = new Teacher(name, surname, department, degree, salary, email, password);
        authService.register(teacher);
        service.add(teacher);
        System.out.println("Teacher created");
    }

    public void delete(int id) {
        service.delete(id);
    }

    public void printAll() {
        service.getAll()
                .forEach(System.out::println);
    }

    public double calculateTotalSalary() {
        return service.calculateTotalSalary();
    }

    public void filterByDegree(String degree) {
        service.filterByDegree(degree);
    }
}

/**
 * Controller class for managing Student-related operations.
 *
 * <p>This class acts as an intermediary between the user interface and
 * the business logic layers (StudentService and AuthService).</p>
 *
 * <p>Provides functionality to:
 * <ul>
 *     <li>Create and register new students</li>
 *     <li>Delete students by ID</li>
 *     <li>Display all students</li>
 *     <li>Assign roles such as starosta and deputy</li>
 * </ul>
 *
 * <p><b>Note:</b>
 * Student creation includes both registration in the authentication system
 * and addition to the student service.</p>
 */

package ua.shid11.controller;

import ua.shid11.model.Student;
import ua.shid11.security.AuthService;
import ua.shid11.security.AuthServiceImpl;
import ua.shid11.service.StudentService;
import ua.shid11.service.impl.StudentServiceImpl;
import ua.shid11.exception.StudentNotFoundException;

public class StudentController {
    private final StudentService service = new StudentServiceImpl();
    private final AuthService authService = new AuthServiceImpl();

    public void create(String name, String surname, String group, String email, String password) {
        Student student = new Student(name, surname, group, email, password);
        authService.register(student);
        service.add(student);
        System.out.println("Student created");
    }

    public void delete(int id) {
        service.delete(id);
    }

    public void printAll() {
        service.getAll()
                .forEach(System.out::println);
    }

    public void assignStarosta(int id) {
        try {
            service.assignStarosta(id);
        } catch (StudentNotFoundException | IllegalArgumentException | IllegalStateException e) {
            System.out.println("Assign starosta failed: " + e.getMessage());
        }
    }

    public void assignDeputy(int id) {
        try {
            service.assignDeputy(id);
        } catch (StudentNotFoundException | IllegalArgumentException | IllegalStateException e) {
            System.out.println("Assign deputy failed: " + e.getMessage());
        }
    }
}

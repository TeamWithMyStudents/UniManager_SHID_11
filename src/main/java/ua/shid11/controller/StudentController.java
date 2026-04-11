package ua.shid11.controller;

import ua.shid11.model.Student;
import ua.shid11.security.AuthService;
import ua.shid11.security.AuthServiceImpl;
import ua.shid11.service.StudentService;
import ua.shid11.service.impl.StudentServiceImpl;
import ua.shid11.exception.StudentNotFoundException;

/**
 * Controller for managing {@link Student} operations, registration, and role assignments.
 */
public class StudentController {
    private final StudentService service = new StudentServiceImpl();
    private final AuthService authService = new AuthServiceImpl();

    /**
     * Registers a student in the auth system and adds them to the service.
     */
    public void create(String name, String surname, String group, String email, String password) {
        Student student = new Student(name, surname, group, email, password);
        authService.register(student);
        service.add(student);
        System.out.println("Student created");
    }

    /**
     * Removes a student by their unique ID.
     */
    public void delete(int id) {
        service.delete(id);
    }

    /**
     * Prints all students to the console.
     */
    public void printAll() {
        service.getAll()
                .forEach(System.out::println);
    }

    /**
     * Assigns the "Starosta" (group leader) role to a student.
     */
    public void assignStarosta(int id) {
        try {
            service.assignStarosta(id);
        } catch (StudentNotFoundException | IllegalArgumentException | IllegalStateException e) {
            System.out.println("Assign starosta failed: " + e.getMessage());
        }
    }

    /**
     * Assigns the "Deputy" (vice-leader) role to a student.
     */
    public void assignDeputy(int id) {
        try {
            service.assignDeputy(id);
        } catch (StudentNotFoundException | IllegalArgumentException | IllegalStateException e) {
            System.out.println("Assign deputy failed: " + e.getMessage());
        }
    }
}

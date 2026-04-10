package ua.shid11.service.impl;

import ua.shid11.exception.StudentNotFoundException;
import ua.shid11.model.Student;
import ua.shid11.service.StudentService;
import ua.shid11.model.enums.StudentRole;

/**
 * Service for student-specific business logic, including role management and group operations.
 * Extends {@link UserServiceImpl} to reuse base CRUD functionality.
 */
public class StudentServiceImpl extends UserServiceImpl<Student> implements StudentService {
    public StudentServiceImpl() {
        super();
    }

    /**
     * Filters and prints students belonging to a specific group.
     * @param groupName the name of the group to search for
     * @throws IllegalArgumentException if groupName is null
     */
    @Override
    public void findByGroup(String groupName) {
        if (groupName == null) {
            throw new IllegalArgumentException("Group name must not be null");
        }

        boolean found = false;
        for (Student student : repository) {
            if (groupName.equals(student.getGroup())) {
                System.out.println(student);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No students found in group: " + groupName);
        }
    }

    /**
     * Assigns the Starosta role to a student and removes it from the previous holder in the same group.
     * @param studentId unique identifier of the student
     * @throws StudentNotFoundException if student doesn't exist
     * @throws IllegalStateException if the student has no valid group
     */
    @Override
    public void assignStarosta(int studentId) {
        if (studentId <= 0) {
            throw new IllegalArgumentException("Invalid student id");
        }
        Student target = null;
        for (Student s : repository) {
            if (s != null && s.getId() == studentId) {
                target = s;
                break;
            }
        }
        if (target == null) {
            throw new StudentNotFoundException("Student not found");
        }
        if (target.getGroup() == null || target.getGroup().isBlank()) {
            throw new IllegalStateException("Student has invalid group");
        }
        if (target.getRole() == StudentRole.STAROSTA) {
            System.out.println("Already a Starosta");
            return;
        }
        String group = target.getGroup();

        for (Student s : repository) {
            if (s != null) {
                if (group.equals(s.getGroup()) && s.getRole() == StudentRole.STAROSTA) {
                    s.setRole(StudentRole.REGULAR);
                }
            }
        }
        target.setRole(StudentRole.STAROSTA);
        System.out.println("Starosta assigned: " + target.getName() + " is now Starosta in group: " + group);
    }

    /**
     * Assigns the Deputy role to a student. Starostas cannot be assigned as deputies.
     * @param studentId unique identifier of the student
     * @throws IllegalStateException if a Starosta tries to become a Deputy
     */
    @Override
    public void assignDeputy(int studentId) {
        if (studentId <= 0) {
            throw new IllegalArgumentException("Invalid student id");
        }
        Student target = null;
        for (Student s : repository) {
            if (s != null && s.getId() == studentId) {
                target = s;
                break;
            }
        }
        if (target == null) {
            throw new StudentNotFoundException("Student not found");
        }
        if (target.getGroup() == null || target.getGroup().isBlank()) {
            throw new IllegalStateException("Student has invalid group");
        }
        if (target.getRole() == StudentRole.STAROSTA) {
            throw new IllegalStateException("Starosta cannot be deputy");
        }
        if (target.getRole() == StudentRole.DEPUTY_STAROSTA) {
            System.out.println("Already a Deputy");
            return;
        }
        String group = target.getGroup();
        for (Student s : repository) {
            if (s != null) {
                if (group.equals(s.getGroup()) && s.getRole() == StudentRole.DEPUTY_STAROSTA) {
                    s.setRole(StudentRole.REGULAR);
                }
            }
        }
        target.setRole(StudentRole.DEPUTY_STAROSTA);
        System.out.println("Deputy assigned: " + target.getName() + " is now Deputy in group: " + group);
    }
}

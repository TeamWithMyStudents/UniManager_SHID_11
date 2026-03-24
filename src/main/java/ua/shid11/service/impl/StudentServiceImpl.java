package ua.shid11.service.impl;

import ua.shid11.exception.StudentNotFoundException;
import ua.shid11.model.Student;
import ua.shid11.service.StudentService;
import ua.shid11.model.enums.StudentRole;


public class StudentServiceImpl extends UserServiceImpl<Student> implements StudentService {
    public StudentServiceImpl() {
        super();
    }

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

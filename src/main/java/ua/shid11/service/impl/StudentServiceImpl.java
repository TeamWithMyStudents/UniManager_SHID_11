package ua.shid11.service.impl;

import ua.shid11.model.Student;
import ua.shid11.service.StudentService;


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
}

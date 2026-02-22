package ua.shid11.service.impl;

import ua.shid11.model.Student;
import ua.shid11.model.User;
import ua.shid11.service.StudentService;

import java.util.Arrays;

public class StudentServiceImpl extends UserServiceImpl implements StudentService {
    public StudentServiceImpl() {
        super(new Student[5]);
    }

    @Override
    public Student[] findByGroup(String groupName) {
        if (groupName == null) return new Student[0];

        int size = 0;
        User[] all = getAll();
        Student[] students = new Student[all.length];

        for (User u : all) {
            if (u instanceof Student && groupName.equals(((Student) u).getGroup())) {
                students[size] = (Student) u;
                size++;
            }
        }
        return Arrays.copyOf(students, size);
    }
}

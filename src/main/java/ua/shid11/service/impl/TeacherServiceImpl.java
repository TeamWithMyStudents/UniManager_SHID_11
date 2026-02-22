package ua.shid11.service.impl;

import ua.shid11.model.Teacher;
import ua.shid11.model.User;
import ua.shid11.service.TeacherService;

public class TeacherServiceImpl extends UserServiceImpl implements TeacherService {
    public TeacherServiceImpl() {
        super(new Teacher[5]);
    }

    @Override
    public void calculateTotalSalary() {
        double total = 0;

        for(User user : getAll()) {
            Teacher teacher = (Teacher) user;
            total += teacher.getSalary();
        }

        System.out.println("Total salary = " + total);
    }

    @Override
    public void filterByDegree(String degree) {
        if (degree == null) {
            return;
        }

        for (User user : getAll()) {
            Teacher teacher = (Teacher) user;
            if (teacher.getDegree() != null && teacher.getDegree().equals(degree)) {
                System.out.println(teacher);
            }
        }
    }
}

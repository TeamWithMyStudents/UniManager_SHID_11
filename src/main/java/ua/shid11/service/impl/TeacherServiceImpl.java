package ua.shid11.service.impl;

import ua.shid11.model.Teacher;
import ua.shid11.service.TeacherService;

public class TeacherServiceImpl extends UserServiceImpl<Teacher> implements TeacherService {
    public TeacherServiceImpl() {
        super();
    }


    @Override
    public double calculateTotalSalary() {
        double total = 0;

        for (Teacher teacher : getAll()) {
            total += teacher.getSalary();
        }

        return total;
    }

    @Override
    public void filterByDegree(String degree) {
        if (degree == null || degree.isBlank()) {
            throw new IllegalArgumentException("Degree cannot be empty");
        }

        boolean found = false;

        for (Teacher teacher : getAll()) {
            if (teacher.getDegree() != null && teacher.getDegree().equals(degree)) {
                System.out.println(teacher);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No Teacher with degree " + degree);
        }
    }

    @Override
    public void add(Teacher teacher) {
        if (teacher.getSalary() <= 0) {
            throw new IllegalArgumentException("Invalid Salary");
        }
        super.add(teacher);
    }
}
package ua.shid11.service.impl;

import ua.shid11.model.Teacher;
import ua.shid11.model.User;
import ua.shid11.service.TeacherService;

public class TeacherServiceImpl extends UserServiceImpl implements TeacherService {
    public TeacherServiceImpl() {
        super(new Teacher[5]);
    }


    @Override
    public double calculateTotalSalary() {
        double total = 0;

        for (User user : getAll()) {
            Teacher teacher = (Teacher) user;
            total += teacher.getSalary();
        }

        System.out.println("Total salary = " + total);
        return total;
    }

    @Override
    public void filterByDegree(String degree) {
        if (degree == null) {
            System.out.println("Degree cannot be empty");
            return;
        }

        boolean found = false;

        for (User user : getAll()) {
            Teacher teacher = (Teacher) user;
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
    public void add(User user) {
        if (!(user instanceof Teacher teacher)) {
            System.out.println("Invalid user type");
            return;
        }
        if (teacher.getSalary() <= 0) {
                System.out.println("Invalid Salary");
                return;
            }
            super.add(user);
            System.out.println("Teacher created");
        }
    }
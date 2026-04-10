package ua.shid11.service.impl;

import ua.shid11.model.Teacher;
import ua.shid11.service.TeacherService;

/**
 * Service implementation for {@link Teacher} operations, including salary
 * calculations and degree filtering.
 * Extends {@link UserServiceImpl} to handle base CRUD logic.
 */
public class TeacherServiceImpl extends UserServiceImpl<Teacher> implements TeacherService {
    public TeacherServiceImpl() {
        super();
    }

    /**
     * Calculates the total sum of salaries for all registered teachers.
     * @return total salary amount
     */
    @Override
    public double calculateTotalSalary() {
        double total = 0;

        for (Teacher teacher : getAll()) {
            total += teacher.getSalary();
        }

        return total;
    }

    /**
     * Filters and prints teachers who hold the specified academic degree.
     * @param degree the degree to filter by
     * @throws IllegalArgumentException if the degree string is null or blank
     */
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

    /**
     * Adds a teacher to the repository after validating their salary.
     * @param teacher the teacher object to add
     * @throws IllegalArgumentException if salary is less than or equal to zero
     */
    @Override
    public void add(Teacher teacher) {
        if (teacher.getSalary() <= 0) {
            throw new IllegalArgumentException("Invalid Salary");
        }
        super.add(teacher);
    }
}
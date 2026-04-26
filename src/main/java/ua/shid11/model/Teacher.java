package ua.shid11.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents a teacher with academic attributes and salary.
 * Extends the {@link User} class with validation for department, degree, and salary.
 */
@Getter
@Setter
@ToString
public class Teacher extends User {
    private String department;
    private String degree;
    private double salary;

    /**
     * Constructs a new Teacher with validated attributes.
     * Defaults to "Unknown" for empty strings and 0 for negative salaries.
     */
    public Teacher(String name, String surname, String department, String degree, double salary, String email, String password) {
        super(name, surname, email, password);

        if (department == null || department.isBlank()) {
            this.department = "Unknown";
        } else {
            this.department = department;
        }

        if (degree == null || degree.isBlank()) {
            this.degree = "Unknown";
        } else {
            this.degree = degree;
        }

        if (salary > 0) {
            this.salary = salary;
        } else {
            this.salary = 0;
        }
    }
}

package ua.shid11.model;

/**
 * Represents a teacher with academic attributes and salary.
 * Extends the {@link User} class with validation for department, degree, and salary.
 */
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

    /** @return the academic department of the teacher. */
    public String getDepartment() {
        return department;
    }

    /** @param department the new department name. */
    public void setDepartment(String department) {
        this.department = department;
    }

    /** @return the teacher's academic degree. */
    public String getDegree() {
        return degree;
    }

    /** @param degree the new academic degree. */
    public void setDegree(String degree) {
        this.degree = degree;
    }

    /** @return the teacher's monthly salary. */
    public double getSalary() {
        return salary;
    }

    /** @param salary the new salary amount. */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", department='" + department + '\'' +
                ", degree='" + degree + '\'' +
                ", salary=" + salary;
    }
}

package ua.shid11.model;

public class Teacher extends User {
    private String department;
    private String degree;
    private double salary;

    public Teacher(String name, String surname, String department, String degree, double salary) {
        super(name, surname);

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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public double getSalary() {
        return salary;
    }

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

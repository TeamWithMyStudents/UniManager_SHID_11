package ua.shid11.model;

public class Student extends User {
    private String group;

    public Student(String name, String surname, String group) {
        super(name, surname);
        this.group = group;
    }

    public Student(String name, String surname) {
        super(name, surname);
    }

    public String getGroup() {
        return group;
    }

    @Override
    public String toString() {
        return "Student{" +
                super.toString() +
                ", group='" + group + '\'' +
                '}';
    }
}

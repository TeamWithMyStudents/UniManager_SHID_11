package ua.shid11.model;

import ua.shid11.model.enums.StudentRole;

public class Student extends User {
    private String group;
    private StudentRole role;

    public Student(String name, String surname, String group, String email, String password) {
        super(name, surname, email, password);
        this.group = group;
        this.role = StudentRole.REGULAR;
    }

    public StudentRole getRole() {
        return role;
    }

    public void setRole(StudentRole role) {
        this.role = role;
    }


    public String getGroup() {
        return group;
    }


    @Override
    public String toString() {
        return "Student{" + "id=" + getId() + ", name='" + getName() + '\'' + ", surname='" + getSurname() + '\'' + ", group='" + group + '\'' + ", role='" + role.getDisplayName() + '\'' + '}';
    }
}

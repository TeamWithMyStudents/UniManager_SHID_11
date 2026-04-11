package ua.shid11.model;

import ua.shid11.model.enums.StudentRole;

/**
 * Represents a student with a specific group and administrative role.
 * Extends the {@link User} class.
 */
public class Student extends User {
    private String group;
    private StudentRole role;

    /**
     * Constructs a new Student and assigns the {@link StudentRole#REGULAR} role by default.
     */
    public Student(String name, String surname, String group, String email, String password) {
        super(name, surname, email, password);
        this.group = group;
        this.role = StudentRole.REGULAR;
    }

    /** @return current administrative role of the student. */
    public StudentRole getRole() {
        return role;
    }

    /** @param role the new {@link StudentRole} to be assigned. */
    public void setRole(StudentRole role) {
        this.role = role;
    }

    /** @return the identifier of the student's group. */
    public String getGroup() {
        return group;
    }


    @Override
    public String toString() {
        return "Student{" + "id=" + getId() + ", name='" + getName() + '\'' + ", surname='" + getSurname() + '\'' + ", group='" + group + '\'' + ", role='" + role.getDisplayName() + '\'' + '}';
    }
}

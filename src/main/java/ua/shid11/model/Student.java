package ua.shid11.model;

import lombok.Getter;
import lombok.Setter;
import ua.shid11.model.enums.StudentRole;

/**
 * Represents a student with a specific group and administrative role.
 * Extends the {@link User} class.
 */
@Getter
@Setter
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

    @Override
    public String toString() {
        return "Student{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", surname='" + getSurname() + '\'' +
                ", group='" + group + '\'' +
                ", role='" + (role != null ? role.getDisplayName() : "null") + '\'' + '}';
    }
}

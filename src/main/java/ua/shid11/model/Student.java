/**
 * Represents a Student entity in the system.
 *
 * <p>This class extends the base {@link User} class and adds additional
 * attributes specific to students, such as group and role.</p>
 *
 * <p>Each student is assigned a default role of {@link ua.shid11.model.enums.StudentRole#REGULAR}
 * upon creation.</p>
 *
 * <p>The class provides access to:
 * <ul>
 *     <li>Student group</li>
 *     <li>Student role (e.g., REGULAR, STAROSTA, DEPUTY)</li>
 * </ul>
 *
 * <p>The role can be updated during runtime using a setter method.</p>
 */

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

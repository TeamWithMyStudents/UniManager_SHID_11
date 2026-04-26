package ua.shid11.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Abstract base class for all system users.
 * Provides unique ID generation and common attributes like name, email, and password.
 */
@Getter
@Setter
@ToString
public abstract class User {
    private int id;
    private String name;
    private String surname;

    @ToString.Exclude
    private String email;

    @ToString.Exclude
    private String password;

    private static int counter = 1;

    /**
     * Constructs a User with a unique incremental ID.
     * Defaults to "Unknown" if name or surname is null.
     */
    public User(String name, String surname, String email, String password) {
        this.name = (name != null) ? name : "Unknown";
        this.surname = (surname != null) ? surname : "Unknown";
        this.id = counter++;
        this.email = email;
        this.password = password;
    }
}

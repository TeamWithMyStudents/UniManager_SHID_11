package ua.shid11.model;

/**
 * Abstract base class for all system users.
 * Provides unique ID generation and common attributes like name, email, and password.
 */
public abstract class User {
    private int id;
    private String name;
    private String surname;
    private static int counter = 1;
    private String email;
    private String password;

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

    /** @return the unique identifier of the user. */
    public int getId() {
        return id;
    }

    /** @return the user's first name. */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /** @return the user's surname. */
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    /** @return the user's account password. */
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /** @return the user's unique email address. */
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name='" + name + '\'' + ", surname='" + surname + '\'' + '}';
    }
}

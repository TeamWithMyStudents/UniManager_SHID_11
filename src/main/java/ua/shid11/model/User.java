package ua.shid11.model;

public abstract class User {
    private int id;
    private String name;
    private String surname;
    private static int counter = 1;
    private String email;
    private String password;

    public User(String name, String surname, String email, String password) {
        this.name = (name != null) ? name : "Unknown";
        this.surname = (surname != null) ? surname : "Unknown";
        this.id = counter++;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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

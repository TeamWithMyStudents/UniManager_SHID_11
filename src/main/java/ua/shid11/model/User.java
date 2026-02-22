package ua.shid11.model;

public abstract class User {
    private int id;
    private String name;
    private String surname;
    private static int counter = 1;

    public User(String name, String surname) {
            this.name = (name != null) ? name : "Unknown";
            this.surname = (surname != null) ? surname : "Unknown";
            this.id = counter++;
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

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name='" + name + '\'' + ", surname='" + surname + '\'' + '}';
    }
}

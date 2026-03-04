package ua.shid11.service;

import ua.shid11.model.User;

public interface UserService {
    void add(User u);

    void delete(int id);

    User[] getAll();

    void findByName(String query);

    void sortBySurname();

}

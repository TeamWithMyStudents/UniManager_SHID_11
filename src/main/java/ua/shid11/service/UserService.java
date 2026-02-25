package ua.shid11.service;

import ua.shid11.model.User;

import java.util.List;

public interface UserService {
    void add(User u);

    void delete(int id);

    List<User> getAll();
}

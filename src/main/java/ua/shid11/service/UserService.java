package ua.shid11.service;

import ua.shid11.model.User;
import java.util.List;

public interface UserService<T extends User> {

    void add(T u);

    void delete(int id);

    List<T> getAll();

    void findByName(String query);

    void sortBySurname();
}
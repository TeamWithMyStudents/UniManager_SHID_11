package ua.shid11.service.impl;

import ua.shid11.model.User;
import ua.shid11.service.UserService;

import java.util.Arrays;

public abstract class UserServiceImpl implements UserService {
    protected User[] repository;
    private int size = 0;


    public UserServiceImpl(User[] initialArray) {
        this.repository = initialArray;
    }

    @Override
    public void add(User u) {
        if (u == null) return;
        if (size >= repository.length) repository = Arrays.copyOf(repository, (size == 0) ? 1 : size * 2);
        repository[size] = u;
        size++;
    }

    @Override
    public void delete(int id) {
        int index = findId(id);

        if (index != -1) {
            for (int i = index; i < size - 1; i++) {
                repository[i] = repository[i + 1];
            }
            size--;
            repository[size] = null;
        } else System.out.println("Id not found");
    }


    @Override
    public User[] getAll() {
        return Arrays.copyOf(repository, size);
    }


    private int findId(int id) {
        for (int i = 0; i < size; i++) {
            if (repository[i] != null && id == repository[i].getId())
                return i;
        }
        return -1;
    }
}

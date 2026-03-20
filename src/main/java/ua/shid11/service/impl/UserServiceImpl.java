package ua.shid11.service.impl;

import ua.shid11.model.User;
import ua.shid11.service.UserService;

import java.util.ArrayList;
import java.util.List;

public abstract class UserServiceImpl implements UserService {
    protected List<User> repository;


    public UserServiceImpl() {
        this.repository = new ArrayList<>();
    }

    @Override
    public void add(User u) {
        if (u != null) {
            repository.add(u);
        }
    }

    @Override
    public void delete(int id) {
        int index = findId(id);

        if (index != -1) {
           repository.remove(index);
        }
    }


    @Override
    public List<User> getAll() {
        return new ArrayList<>(repository);
    }


    private int findId(int id) {
        for (int i = 0; i < repository.size(); i++) {
            if (repository.get(i) != null && id == repository.get(i).getId()) {
                return i;
            }
        }
        return -1;
    }
}

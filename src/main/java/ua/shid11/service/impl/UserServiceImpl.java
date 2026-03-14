package ua.shid11.service.impl;

import ua.shid11.model.User;
import ua.shid11.service.UserService;

import java.util.Arrays;
import java.util.Locale;
import java.text.Collator;
import java.util.Comparator;

public abstract class UserServiceImpl implements UserService {
    protected User[] repository;
    private int size = 0;


    public UserServiceImpl(User[] initialArray) {
        this.repository = initialArray;
    }

    @Override
    public void add(User u) {
        if (u == null) {
            return;
        }
        if (size >= repository.length) {
            repository = Arrays.copyOf(repository, (size == 0) ? 1 : size * 2);
        }
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
        } else {
            System.out.println("Id not found");
        }
    }


    @Override
    public User[] getAll() {
        return Arrays.copyOf(repository, size);
    }


    private int findId(int id) {
        for (int i = 0; i < size; i++) {
            if (repository[i] != null && id == repository[i].getId()) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void findByName(String query) {

        if (query == null || query.isBlank()) {
            System.out.println("Search query cannot be empty");
            return;
        }
        boolean found = false;
        for (User u : getAll()) {
            if (u.getName() != null && u.getName().toLowerCase().contains(query.toLowerCase())) {
                System.out.println(u);
                found = true;
            }
            }
            if (!found) {
                    System.out.println("No user found with query: " + query);
            }
    }
    @Override
    public void sortBySurname() {
        Collator uaCollator = Collator.getInstance(new Locale("uk", "UA"));
        User[] users = getAll();
        Arrays.sort(users, new Comparator<>() {
            @Override
            public int compare(User u1, User u2) {
                String s1 = (u1.getSurname() == null) ? "" : u1.getSurname();
                String s2 = (u2.getSurname() == null) ? "" : u2.getSurname();
                return uaCollator.compare(s1, s2);
            }
        });
        for (User u : users) {
            System.out.println(u);
        }
    }
}

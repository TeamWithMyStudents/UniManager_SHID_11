package ua.shid11.service.impl;

import ua.shid11.model.User;
import ua.shid11.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.text.Collator;

public abstract class UserServiceImpl<T extends User> implements UserService<T> {
    protected List<T> repository;

    public UserServiceImpl() {
        this.repository = new ArrayList<>();
    }

    @Override
    public void add(T u) {
        if (u == null) {
            throw new IllegalArgumentException("Cannot add a null user to the repository");
        }
        repository.add(u);
    }

    @Override
    public void delete(int id) {
        repository.removeIf(u -> u != null && u.getId() == id);
    }

    @Override
    public List<T> getAll() {
        return new ArrayList<>(repository);
    }

    @Override
    public void findByName(String query) {
        if (query == null || query.isBlank()) {
            throw new IllegalArgumentException("Query must not be null");
        }

        boolean found = false;
        for (T t : repository) {
            if (t.getName() != null && t.getName().toLowerCase().contains(query.toLowerCase())) {
                System.out.println(t);
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
        List<T> users = getAll();

        users.sort((u1, u2) -> {
            String s1 = (u1.getSurname() == null) ? "" : u1.getSurname();
            String s2 = (u2.getSurname() == null) ? "" : u2.getSurname();
            return uaCollator.compare(s1, s2);
        });

        for (T u : users) {
            System.out.println(u);
        }
    }
}
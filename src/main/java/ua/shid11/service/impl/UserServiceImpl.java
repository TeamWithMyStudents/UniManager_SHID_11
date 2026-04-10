package ua.shid11.service.impl;

import ua.shid11.model.User;
import ua.shid11.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.text.Collator;

/**
 * Generic base implementation for user management services.
 * Handles common CRUD operations and sorting for any type extending {@link User}.
 * @param <T> the specific user type (e.g., Student or Teacher)
 */
public abstract class UserServiceImpl<T extends User> implements UserService<T> {
    /** Protected repository allows direct access for subclasses like StudentServiceImpl. */
    protected List<T> repository;

    public UserServiceImpl() {
        this.repository = new ArrayList<>();
    }

    /**
     * Adds a user to the internal storage.
     * @throws IllegalArgumentException if user is null
     */
    @Override
    public void add(T u) {
        if (u == null) {
            throw new IllegalArgumentException("Cannot add a null user to the repository");
        }
        repository.add(u);
    }

    /**
     * Removes a user from the repository based on their unique ID.
     */
    @Override
    public void delete(int id) {
        repository.removeIf(u -> u != null && u.getId() == id);
    }

    /**
     * @return a defensive copy of the user list to preserve encapsulation.
     */
    @Override
    public List<T> getAll() {
        return new ArrayList<>(repository);
    }

    /**
     * Performs a case-insensitive search by user name and prints results.
     * @param query the search string
     */
    @Override
    public void findByName(String query) {
        if (query == null || query.isBlank()) {
            throw new IllegalArgumentException("Query must not be null");
        }

        boolean found = false; // also need to rewrite to stream api
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

    /**
     * Sorts and prints users by surname using Ukrainian locale rules.
     */
    @Override
    public void sortBySurname() {
        repository.stream()
                .sorted((u1, u2) -> {
                    Collator uaCollator = Collator.getInstance(new Locale("uk", "UA"));
                    String s1 = (u1.getSurname() == null) ? "" : u1.getSurname();
                    String s2 = (u2.getSurname() == null) ? "" : u2.getSurname();
                    return uaCollator.compare(s1, s2);
                })
                .forEach(System.out::println);
    }
}
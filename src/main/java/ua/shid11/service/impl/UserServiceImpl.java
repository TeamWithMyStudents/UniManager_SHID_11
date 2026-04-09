/**
 * Abstract generic service implementation for managing User entities.
 *
 * <p>This class provides a base in-memory repository and common CRUD-like
 * operations for all types of users extending {@link User}.</p>
 *
 * <p>It is intended to be extended by specific service implementations
 * such as {@link StudentServiceImpl} and {@link TeacherServiceImpl}.</p>
 *
 * <p>Supported operations include:
 * <ul>
 *     <li>Adding users</li>
 *     <li>Deleting users by ID</li>
 *     <li>Retrieving all users</li>
 *     <li>Searching users by name</li>
 *     <li>Sorting users by surname (using locale-aware comparison)</li>
 * </ul>
 *
 * <p><b>Implementation details:</b>
 * <ul>
 *     <li>Uses an in-memory {@link java.util.List} as a repository</li>
 *     <li>Sorting is performed using {@link java.text.Collator} with Ukrainian locale</li>
 *     <li>Returns defensive copies of collections to preserve encapsulation</li>
 * </ul>
 *
 * @param <T> type of user extending {@link User}
 */

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
/**
 * Implementation of the AuthService interface that handles user registration and login.
 *
 * <p>The class loads registered users from a file on startup and saves them
 * after each successful registration using UserFileHandler.</p>
 *
 * <p>Includes basic validation: email format, password length, and uniqueness of email.</p>
 *
 * <p>If saving to file fails, the registration is rolled back to keep data consistent.</p>
 */

package ua.shid11.security;

import ua.shid11.model.User;
import ua.shid11.util.UserFileHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class AuthServiceImpl implements AuthService {
    private List<User> registeredUsers = new ArrayList<>();

    public AuthServiceImpl() {
        try {
            this.registeredUsers = UserFileHandler.loadUsers();
            System.out.println("Loaded users: " + registeredUsers.size());
        } catch (Exception e) {
            throw new IllegalStateException("Cannot initialize auth storage", e);
        }
    }

    @Override
    public void register(User user) {

        String normalizedEmail = user.getEmail().trim().toLowerCase();
        user.setEmail(normalizedEmail);

        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        if (user.getEmail() == null || !Pattern.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$", user.getEmail())) {
            throw new IllegalArgumentException("Invalid email format");
        }
        if (user.getPassword() == null || user.getPassword().isBlank() || user.getPassword().length() < 8) {
            throw new IllegalArgumentException("Password must be at least 8 characters");
        }

        for (User existingUser : registeredUsers) { // in the future it can be rewritten to stream api
            if (existingUser.getEmail().equals(normalizedEmail)) {
                throw new IllegalArgumentException("User with this email already exists");
            }
        }

        registeredUsers.add(user);
        try {
            UserFileHandler.saveUsers(registeredUsers);
            System.out.println("User successfully registered!");
        } catch (Exception e) {
            registeredUsers.remove(user);
            throw new RuntimeException("User registration failed: cannot save to file", e);
        }
    }

    @Override
    public User login(String email, String password) {

        String normalizedEmail = email == null ? null : email.trim().toLowerCase();
        User foundUser = registeredUsers.stream().filter(user -> user.getEmail().equals(normalizedEmail)).findFirst().orElseThrow(() -> new java.util.NoSuchElementException("User with this email not found"));

        if (foundUser == null) {
            throw new java.util.NoSuchElementException("User with this email not found");
        }

        if (!foundUser.getPassword().equals(password)) {
            throw new IllegalArgumentException("Incorrect password");
        }

        UserSession.login(foundUser);

        return foundUser;
    }
}

package ua.shid11.security;

import ua.shid11.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class AuthServiceImpl implements AuthService {
    private List<User> registeredUsers = new ArrayList<>();

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

        for (User existingUser : registeredUsers) {
            if (existingUser.getEmail().equals(normalizedEmail)) {
                throw new IllegalArgumentException("User with this email already exists");
            }
        }

        registeredUsers.add(user);
    }

    @Override
    public User login(String email, String password) {

        User foundUser = null;

        for (User user : registeredUsers) {
            if (user.getEmail().equals(email)) {
                foundUser = user;
                break;
            }
        }

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

package ua.shid11.security;

import ua.shid11.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class AuthServiceImpl implements AuthService {
    private List<User> registeredUsers = new ArrayList<>();

    @Override
    public void register(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        if (user.getEmail() == null || !Pattern.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$", user.getEmail())) {
            throw new IllegalArgumentException("Invalid email format or password too short");
        }
        if (user.getPassword() == null || user.getPassword().isBlank() || user.getPassword().length() < 8) {
            throw new IllegalArgumentException("Invalid email format or password too short");
        }
        registeredUsers.add(user);
    }
}

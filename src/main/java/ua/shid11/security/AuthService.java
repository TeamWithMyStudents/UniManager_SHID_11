package ua.shid11.security;

import ua.shid11.model.User;

public interface AuthService {
    void register(User user);
    User login(String email, String password);
}

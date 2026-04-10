package ua.shid11.security;

import ua.shid11.model.User;

/**
 * Manages the current authenticated user session in memory.
 * Provides static methods to track, login, and logout the user.
 */
public class UserSession {
    private static User currentUser = null;

    /**
     * Sets the current user session.
     * @param user the user to log in
     * @throws IllegalArgumentException if user is null
     * @throws IllegalStateException if a session is already active
     */
    public static void login(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }

        if (currentUser != null) {
            throw new IllegalStateException("Another user is already logged in");
        }
        currentUser = user;
    }

    /**
     * Clears the current user session.
     */
    public static void logout() {
        currentUser = null;
    }

    /** @return the currently logged-in {@link User} or null if none. */
    public static User getCurrentUser() {
        return currentUser;
    }
    /** @return true if a user is currently logged in. */
    public static boolean isAuthenticated() {
        return currentUser != null;
    }
}

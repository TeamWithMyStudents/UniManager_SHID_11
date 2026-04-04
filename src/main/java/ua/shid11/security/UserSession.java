/**
 * Utility class that manages the current authenticated user session.
 *
 * <p>This class provides a simple in-memory session mechanism
 * for tracking the currently logged-in user.</p>
 *
 * <p>It supports:
 * <ul>
 *     <li>Logging in a user</li>
 *     <li>Logging out the current user</li>
 *     <li>Retrieving the currently authenticated user</li>
 *     <li>Checking authentication status</li>
 * </ul>
 *
 * <p><b>Note:</b>
 * This is a simple session implementation and is not thread-safe.
 * It is intended for learning/demo purposes.</p>
 */

package ua.shid11.security;

import ua.shid11.model.User;

public class UserSession {
    private static User currentUser = null;

    public static void login(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }

        if (currentUser != null) {
            throw new IllegalStateException("Another user is already logged in");
        }
        currentUser = user;
    }

    public static void logout() {
        currentUser = null;
    }

    public static User getCurrentUser() {
        return currentUser;
    }
    public static boolean isAuthenticated() {
        return currentUser != null;
    }
}

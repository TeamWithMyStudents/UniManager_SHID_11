package ua.shid11.security;

import ua.shid11.model.User;

public class UserSession {
    private static User currentUser = null;

    public static void login(User user){
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }

        if (currentUser != null) {
            throw new IllegalStateException("Another user is already logged in");
        }
        currentUser = user;
    }

    public static void logout(){
        currentUser = null;
    }

    public static User getCurrentUser(){
        return currentUser;
    }
    public static boolean isAuthenticated(){
        return currentUser != null;
    }
}

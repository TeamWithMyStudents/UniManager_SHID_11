package ua.shid11.model.enums;

/**
 * Represents the administrative roles a student can hold within a group.
 */
public enum StudentRole {
    STAROSTA("Староста"),
    DEPUTY_STAROSTA("Заступник"),
    REGULAR("Студент");

    private final String displayName;

    StudentRole(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}

package ua.shid11.model.enums;

public enum StudentRole {
    STAROSTA("Староста"),
    DEPUTY_STAROSTE("Заступник"),
    REGULAR("Студент");

    private final String displayName;
    StudentRole(String displayName) {
        this.displayName = displayName;
    }
    public String getDisplayName() {
        return displayName;
    }
}

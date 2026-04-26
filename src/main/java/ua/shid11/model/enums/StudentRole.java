package ua.shid11.model.enums;

import lombok.Getter;

/**
 * Represents the administrative roles a student can hold within a group.
 */
@Getter
public enum StudentRole {
    STAROSTA("Староста"),
    DEPUTY_STAROSTA("Заступник"),
    REGULAR("Студент");

    private final String displayName;

    StudentRole(String displayName) {
        this.displayName = displayName;
    }

}

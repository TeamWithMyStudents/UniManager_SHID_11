package ua.shid11.exception;

/**
 * Thrown to indicate that a requested student could not be found in the system.
 */
public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(String message) {
        super(message);
    }
}

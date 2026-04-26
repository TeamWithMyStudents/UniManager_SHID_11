package ua.shid11.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents a student's grade for a specific subject.
 */
@Getter
@Setter
@ToString
public class Grade {
    private int studentId;
    private String subject;
    private int score;

    /**
     * Constructs a new Grade instance with score validation.
     *
     * @param studentId the unique ID of the student
     * @param subject   the name of the subject
     * @param score     the score achieved (must be between 0 and 100)
     * @throws IllegalArgumentException if the score is outside the valid range
     */
    public Grade(int studentId, String subject, int score) {
        this.studentId = studentId;
        this.subject = subject;
        validateScore(score);
        this.score = score;
    }

    /**
     * Validates whether the provided score is within the acceptable range.
     *
     * @param scoreValue the score value to check
     * @throws IllegalArgumentException if the score is less than 0 or greater than 100
     */
    private void validateScore(int scoreValue) {
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("Grade must be between 0 and 100");
        }
    }
}

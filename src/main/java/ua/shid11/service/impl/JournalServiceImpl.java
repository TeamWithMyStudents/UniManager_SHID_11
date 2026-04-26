package ua.shid11.service.impl;

import ua.shid11.model.Grade;
import ua.shid11.service.JournalService;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the {@link JournalService} for managing student grades.
 * This service stores grades in an in-memory list.
 */
public class JournalServiceImpl implements JournalService {

    private final List<Grade> journal = new ArrayList<>();

    /**
     * Assigns a new grade to a student and adds it to the journal.
     *
     * @param studentId the unique identifier of the student
     * @param subject   the name of the academic subject
     * @param score     the score achieved by the student
     * @throws IllegalArgumentException if the score validation fails in the Grade constructor
     */
    @Override
    public void assignGrade(int studentId, String subject, int score) {
        if (subject == null || subject.isBlank()){
            throw new IllegalArgumentException("Subject must not be null or blank");
        }
        Grade grade = new Grade(studentId, subject, score);
        journal.add(grade);
    }

    @Override
    public List<Grade> getGradesForStudent(int studentId) {

        return journal.stream()
                .filter(g -> g.getStudentId() == studentId)
                .map(g -> new Grade(g.getStudentId(), g.getSubject(), g.getScore()))
                .toList();
    }
}
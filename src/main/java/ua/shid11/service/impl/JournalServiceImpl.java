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
        if (subject == null || subject.isBlank()) {
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

    /**
     * Generates a formatted academic report for a specific student.
     * @return a formatted string containing all grades and the average score,
     * or a message stating no grades are available.
     */
    @Override
    public String generateRecordBook(int studentId) {
        List<Grade> studentGrades = getGradesForStudent(studentId);
        if (studentGrades.isEmpty()) {
            return "No grades for this student";
        }
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append("--- Record Book for Student ID: ")
                     .append(studentId)
                     .append(" ---\n");

        double sum = 0;
        for (Grade grade : studentGrades) {
            reportBuilder.append("Subject: ")
                         .append(grade.getSubject())
                         .append(" | Score: ")
                         .append(grade.getScore())
                         .append("\n");
            sum += grade.getScore();
        }

        double average = sum / studentGrades.size();
        reportBuilder.append("Average Score: ")
                .append(String.format("%.2f", average));

        return reportBuilder.toString();
    }
}
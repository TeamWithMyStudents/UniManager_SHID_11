package ua.shid11.service.impl;

import ua.shid11.model.Grade;
import ua.shid11.service.JournalService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JournalServiceImpl implements JournalService {

    private final List<Grade> journal = new ArrayList<>();

    @Override
    public void assignGrade(int studentId, String subject, int score) {

        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("Grade must be between 0 and 100");
        }

        Grade grade = new Grade(studentId, subject, score);

        journal.add(grade);
    }

    @Override
    public List<Grade> getGradesForStudent(int studentId) {

        return journal.stream()
                .filter(g -> g.getStudentId() == studentId)
                .collect(Collectors.toList());
    }
}
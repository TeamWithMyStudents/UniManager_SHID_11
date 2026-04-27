package ua.shid11.service;

import ua.shid11.model.Grade;
import java.util.List;

public interface JournalService {
    void assignGrade(int studentId, String subject, int score);
    List<Grade> getGradesForStudent(int studentId);

    String generateRecordBook(int studentId);
}
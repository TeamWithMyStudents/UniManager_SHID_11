package ua.shid11.service.impl;

import ua.shid11.model.Lesson;
import ua.shid11.service.ScheduleService;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ScheduleServiceImpl implements ScheduleService {
    private final List<Lesson> lessons = new ArrayList<>();

    @Override
    public void addLesson(String day, String time, String subject, String teacherSurname) {
        if (day == null || time == null || subject == null || teacherSurname == null) {
            throw new IllegalArgumentException("Input data can't be null");
        }
        if (day.isBlank() || time.isBlank() || subject.isBlank() || teacherSurname.isBlank()) {
            throw new IllegalArgumentException("Input data can't be blank");
        }
        try {
            DayOfWeek dayOfWeek = DayOfWeek.valueOf(day.trim().toUpperCase(Locale.ROOT));
            LocalTime lessonTime = LocalTime.parse(time.trim(), DateTimeFormatter.ofPattern("HH:mm"));

            Lesson lesson = new Lesson(subject.trim(), teacherSurname.trim(), lessonTime, dayOfWeek);
            lessons.add(lesson);
        } catch (DateTimeParseException | IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid time format (HH:mm) or day of the week", e);
        }
    }

    @Override
    public List<Lesson> getLessonsByDay(DayOfWeek dayOfWeek) {
        if (dayOfWeek == null) {
            throw new IllegalArgumentException("Day of week can't be null");
        }
        return lessons.stream().filter(lesson -> lesson.getDayOfWeek() == dayOfWeek).toList();
    }

    @Override
    public List<Lesson> getAllSortedByTime() {
        return lessons.stream().sorted(Comparator.comparing(Lesson::getTime)).toList();
    }
}

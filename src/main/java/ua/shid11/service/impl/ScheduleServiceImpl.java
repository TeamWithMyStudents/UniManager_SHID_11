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

/**
 * Implementation of {@link ScheduleService} for managing academic lessons.
 * Provides functionality to add, filter, and sort lessons using in-memory storage.
 */
public class ScheduleServiceImpl implements ScheduleService {
    private final List<Lesson> lessons = new ArrayList<>();

    /**
     * Parses input data and adds a new lesson to the schedule.
     * @param day            name of the day (e.g., "MONDAY")
     * @param time           time in "HH:mm" format (e.g., "14:30")
     * @param subject        name of the subject
     * @param teacherSurname surname of the instructor
     * @throws IllegalArgumentException if inputs are null/blank or format is invalid
     */
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

    /**
     * @param dayOfWeek the day to filter by
     * @return a list of lessons for the specified day
     * @throws IllegalArgumentException if dayOfWeek is null
     */
    @Override
    public List<Lesson> getLessonsByDay(DayOfWeek dayOfWeek) {
        if (dayOfWeek == null) {
            throw new IllegalArgumentException("Day of week can't be null");
        }
        return lessons.stream().filter(lesson -> lesson.getDayOfWeek() == dayOfWeek).toList();
    }

    /**
     * @return all lessons sorted chronologically by time, regardless of the day.
     */
    @Override
    public List<Lesson> getAllSortedByTime() {
        return lessons.stream()
                .sorted(Comparator.comparing(Lesson::getTime))
                .toList();
    }
}

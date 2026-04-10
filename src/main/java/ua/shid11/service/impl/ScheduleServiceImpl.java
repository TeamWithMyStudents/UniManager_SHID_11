package ua.shid11.service.impl;

import ua.shid11.model.Lesson;
import ua.shid11.service.ScheduleService;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ScheduleServiceImpl implements ScheduleService {
    private final List<Lesson> lessons = new ArrayList<>();

    @Override
    public void addLesson(String day, String time, String subject, String teacherSurname) {
        if (day == null || time == null || subject == null || teacherSurname == null) {
            throw new IllegalArgumentException("Input data can't be null");
        }
        try {
            DayOfWeek dayOfWeek = DayOfWeek.valueOf(day.toUpperCase());
            LocalTime lessonTime = LocalTime.parse(time);

            Lesson lesson = new Lesson(subject, teacherSurname, lessonTime, dayOfWeek);
            lessons.add(lesson);
        } catch (DateTimeParseException | IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid time format (HH:mm) or day of the week");
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

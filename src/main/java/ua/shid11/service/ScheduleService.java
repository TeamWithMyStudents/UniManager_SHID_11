package ua.shid11.service;

import ua.shid11.model.Lesson;

import java.util.List;
import java.time.DayOfWeek;

public interface ScheduleService {

    void addLesson(String day, String time, String subject, String teacherSurname);

    List<Lesson> getLessonsByDay(DayOfWeek dayOfWeek);

    List<Lesson> getAllSortedByTime(); //додатково додав сортування за часом
}

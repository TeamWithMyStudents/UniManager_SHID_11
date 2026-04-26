package ua.shid11.model;

import lombok.Getter;
import lombok.Setter;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents a scheduled academic lesson.
 */
@Getter
@Setter
public class Lesson {
    private DayOfWeek dayOfWeek;
    private LocalTime time;
    private String subject;
    private String teacherSurname;

    /**
     * Constructs a new Lesson with the specified details.
     *
     * @param subject        the title of the subject
     * @param teacherSurname the surname of the instructor
     * @param time           the start time of the lesson
     * @param dayOfWeek      the day of the week
     */
    public Lesson(String subject, String teacherSurname, LocalTime time, DayOfWeek dayOfWeek) {
        this.subject = subject;
        this.teacherSurname = teacherSurname;
        this.time = time;
        this.dayOfWeek = dayOfWeek;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String formattedTime = (time != null) ? time.format(formatter) : "null";
        return "Lesson{" + "dayOfWeek=" + dayOfWeek + ", time=" + formattedTime + ", subject='" + subject + '\'' + ", teacherSurname='" + teacherSurname + '\'' + '}';
    }
}

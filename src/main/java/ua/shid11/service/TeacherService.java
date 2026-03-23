package ua.shid11.service;

import ua.shid11.model.Teacher;

public interface TeacherService extends  UserService<Teacher> {
    double calculateTotalSalary();

    void filterByDegree(String degree);

}

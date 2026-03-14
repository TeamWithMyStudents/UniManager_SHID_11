package ua.shid11.service;

public interface TeacherService extends  UserService {
    double calculateTotalSalary();

    void filterByDegree(String degree);

}

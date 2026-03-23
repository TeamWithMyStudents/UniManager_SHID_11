package ua.shid11.service;


import ua.shid11.model.Student;

public interface StudentService extends UserService<Student> {

    void findByGroup(String groupName);
}

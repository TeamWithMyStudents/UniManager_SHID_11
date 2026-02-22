package ua.shid11.service;

import ua.shid11.model.Student;

public interface StudentService extends UserService {

    void findByGroup(String groupName);
}

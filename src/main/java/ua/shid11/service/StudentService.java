package ua.shid11.service;


public interface StudentService extends UserService {

    void findByGroup(String groupName);
}

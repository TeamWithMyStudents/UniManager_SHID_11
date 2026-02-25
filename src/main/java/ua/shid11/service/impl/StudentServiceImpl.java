package ua.shid11.service.impl;

import ua.shid11.model.Student;
import ua.shid11.model.User;
import ua.shid11.service.StudentService;


public class StudentServiceImpl extends UserServiceImpl implements StudentService {
    public StudentServiceImpl() {
        super();
    }

    @Override
    public void findByGroup(String groupName) {
        if (groupName == null) {
            return;
        }

        boolean found = false;
        for (User u : getAll()) {
            if (u instanceof Student && groupName.equals(((Student) u).getGroup())) {
                System.out.println(u);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No students found in group: " + groupName);
        }
    }
}

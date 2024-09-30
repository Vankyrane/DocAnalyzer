package com.docanalyzer.project.service;

import com.docanalyzer.project.model.User;
import com.docanalyzer.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private List<User> inactiveUserList = new ArrayList();

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getInactiveUsers() {
        return userRepository.findInactiveUsers();
    }
}

package com.docanalyzer.project.service;

import com.docanalyzer.project.model.User;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private List<User> inactiveUserList = new ArrayList();

    @Override
    public List<User> getInactiveUsers() {
        return inactiveUserList;
    }
}

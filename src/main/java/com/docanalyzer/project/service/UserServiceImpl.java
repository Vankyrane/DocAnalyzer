package com.docanalyzer.project.service;

import com.docanalyzer.project.model.User;
import com.docanalyzer.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

//Service to Find Inactive Users
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getInactiveUsers(LocalDate starDate, LocalDate endDate) {
        return userRepository.findInactiveUsers(starDate, endDate);
    }
}

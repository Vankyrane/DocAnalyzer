package com.docanalyzer.project.service;

import com.docanalyzer.project.model.User;

import java.util.List;

public interface UserService {

    List<User> getInactiveUsers();
}

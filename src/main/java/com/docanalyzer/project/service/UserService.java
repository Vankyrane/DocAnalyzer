package com.docanalyzer.project.service;

import com.docanalyzer.project.model.User;

import java.time.LocalDate;
import java.util.List;

public interface UserService {


    List<User> getInactiveUsers(LocalDate startDate, LocalDate endDate);
}

package com.docanalyzer.project.controller;

import com.docanalyzer.project.model.User;
import com.docanalyzer.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping("/api/public/users/inactive")
    public List<User> getInactiveUsers(){
            return userService.getInactiveUsers();
    }
}

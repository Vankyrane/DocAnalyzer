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

    //API to fetch Inactive Users
    @GetMapping("/api/public/users/inactive")
    public List<User> getInactiveUsers(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                       @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate){
            return userService.getInactiveUsers(startDate, endDate);
    }
}

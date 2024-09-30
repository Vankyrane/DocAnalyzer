package com.docanalyzer.project.model;

public class User {
    private Long userId;
    private String emailId;

    public User(Long userId, String emailId) {
        this.userId = userId;
        this.emailId = emailId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}

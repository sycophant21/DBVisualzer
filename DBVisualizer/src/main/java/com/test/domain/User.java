package com.test.domain;

import java.util.Objects;

public class User {
    private final String pass;
    private final String emailId;


    public User(String pass, String emailId) {
        this.pass = String.valueOf(Objects.hash(pass));
        this.emailId = emailId;
    }


    public String getPass() {
        return pass;
    }


    public String getEmailId() {
        return emailId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getPass().equals(user.getPass()) && getEmailId().equals(user.getEmailId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPass(), getEmailId());
    }
}

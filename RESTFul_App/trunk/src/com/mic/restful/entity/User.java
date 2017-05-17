package com.mic.restful.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "user")
public class User {
    private String userId;
    private String userName;
    private int userAge;

    public User() {

    }

    public User(String userId, String userName, int userAge) {
        this.userId = userId;
        this.userName = userName;
        this.userAge = userAge;
    }

    @XmlElement
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @XmlElement
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @XmlElement
    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }
}

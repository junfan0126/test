package com.cs533.Entity;

import java.io.Serializable;

public class User implements Serializable {

    private int user_id;
    private String username;
    private String password;
    private String nickname;
    private String sex;



    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


    public int getUser_id() {
        return user_id;
    }
}


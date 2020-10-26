package com.cs533.Entity;

import java.util.Date;

/**
 * @author haojunfan
 */
public class Comment {
    private int id;

    private int userId;

    private String username;

    private String content;

    private Date createTime;

    private int greatNum;

    public Comment() {

    }

    public Comment(int id, int userId, String username, String content, Date createTime) {
        this.id = id;
        this.userId = userId;
        this.username = username;
        this.content = content;
        this.createTime = new Date();
    }

    public int getGreatNum() {
        return greatNum;
    }

    public void setGreatNum(int greatNum) {
        this.greatNum = greatNum;
    }

    public Comment(int userId, String username, String content, Date createTime) {
        this.userId = userId;
        this.username = username;
        this.content = content;
        this.createTime = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}

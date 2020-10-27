package com.cs533.Entity;

import java.util.Date;

/**
 * @author
 * @version 1.0
 * @date 2020/10/26 下午1:12
 * @description
 **/

public class Message {

    private long id;

    private long userId;

    private String username;

    private String title;

    private String content;

    private Date create_time;
    
    private int greatNum;

    public Message(long id, int greatNum) {
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public int getGreatNum() {
        return greatNum;
    }

    public void setGreatNum(int greatNum) {
        this.greatNum = greatNum;
    }

    public Message(long userId, String username, String title, String content, Date create_time) {
        this.id = id;
        this.userId = userId;
        this.username = username;
        this.title = title;
        this.content = content;
        this.create_time = create_time;
    }

    public Message(int id, long userId, String username, String title, String content, Date create_time) {
        this.userId = userId;
        this.username = username;
        this.title = title;
        this.content = content;
        this.create_time=create_time;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return create_time;
    }

    public void setCreateTime(Date createTime) {
        this.create_time = createTime;
    }
}

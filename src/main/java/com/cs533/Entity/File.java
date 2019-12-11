package com.cs533.Entity;

import java.util.Date;

/**
 * 文件表对应的实体类
 *
 * @author haojunfan
 */
public class File  {
	private int id;
	private int userId;
	private String username;
    private String title;
    private Date creatTime;





    public File(int userId, String username, String title, Date creatTime) {
        this.id = 0;
        this.userId = userId;
        this.username = username;
        this.title = title;
        this.creatTime = creatTime;
    }

    public File() {

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }
}

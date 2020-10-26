package com.cs533.Service;


import com.cs533.Entity.Comment;
import com.cs533.dao.CommentDao;

import java.util.Date;
import java.util.List;


public class CommentService {
    private CommentDao commentDao;

    public CommentService() {
        commentDao = new CommentDao();
    }

    public boolean addComment(Comment comment) {
        comment.setCreateTime(new Date());
        return commentDao.save(comment);
    }

    public static List<Comment> getComment(int page, int pageSize) {
        return CommentDao.getComment(page, pageSize);
    }

    public int countComment() {
        return commentDao.countComments();
    }
}

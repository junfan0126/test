package com.cs533.Service;


import com.cs533.Entity.Comment;
import com.cs533.Entity.Message;
import com.cs533.dao.CommentDao;

import java.sql.SQLException;
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

    public static List<Comment> getComment(int page, int pageSize) throws SQLException {
        return CommentDao.getComment(page, pageSize);
    }

    public int countComment() {
        return commentDao.countComments();
    }

    /**
     * @author haojunfan
     * @date 2020/10/26 下午4:41
     * @description 更新评论字段内容(点赞)
     **/
    public boolean updateCommentGreatNum(Comment comment) throws SQLException {
        return commentDao.updateCommentGreatNum(comment);
    }


    /**
     * @author haojunfan
     * @date 2020/10/26 下午5:06
     * @description     根据评论ID查询评论
     **/
    public Comment queryCommentById(int commentId) throws SQLException {
        return commentDao.queryCommentById(commentId);
    }
}

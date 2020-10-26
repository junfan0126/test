package com.cs533.dao;

import com.cs533.Entity.Comment;
import com.cs533.Entity.File;
import com.cs533.db.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentDao {


    /**
     * 保存评论信息
     * @param comment
     * @return
     */
    public boolean save(Comment comment) {
        Connection conn = null;
        try {
            conn = ConnectionUtil.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql = "insert into comment(user_id, username, content,create_time) values (?, ?, ?,?)";
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, comment.getUserId());
            stmt.setString(2, comment.getUsername());
            stmt.setString(3, comment.getContent());
            stmt.setDate(4, new Date(System.currentTimeMillis()));
            stmt.execute();
            System.out.println("保存评论失败。");
        } catch (Exception e) {
            System.out.println("保存评论失败。");
            e.printStackTrace();
            return false;
        } finally {
            ConnectionUtil.release(null, stmt, conn);
        }
        return true;
    }

    /**
     * 分页查询
     * @param page     当前页码
     * @param pageSize 每页记录数
     * @return
     */
    public static List<Comment> getComment(int page, int pageSize) {
        Connection conn = null;
        try {
            conn = ConnectionUtil.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql = "select * from comment order by id desc limit ?,?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Comment> comments = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, (page - 1) * pageSize);
            stmt.setInt(2, pageSize);
            rs = stmt.executeQuery();
            while (rs.next()) {
                comments.add(new Comment(rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("content"),
                        rs.getDate("create_time")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.release(rs, stmt, conn);
        }
        return comments;
    }

    /**
     * 计算所有评论数量
     * @return
     */
    public int countComments() {
        Connection conn = null;
        try {
            conn = ConnectionUtil.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql = "select count(*) total from comment";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                return rs.getInt("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.release(rs, stmt, conn);
        }
        return 0;
    }
}



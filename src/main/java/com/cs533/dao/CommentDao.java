package com.cs533.dao;

import com.cs533.Entity.Comment;
import com.cs533.Entity.User;
import com.cs533.db.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentDao {
    /**
     * 保存评论信息
     *
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
            System.out.println("保存评论成功。");
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
     *
     * @param page     当前页码
     * @param pageSize 每页记录数
     * @return
     */
    public static List<Comment> getComment(int page, int pageSize) throws SQLException {
        Connection conn = ConnectionUtil.getConnection();
        String sql = "select * from comment order by id desc limit ?, ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Comment> comments = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, (page - 1) * pageSize);
            stmt.setInt(2, pageSize);
            rs = stmt.executeQuery();
            while (rs.next()) {
                comments.add(new Comment(
                        rs.getInt("id"),
                        rs.getInt("user_id"),
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
     *
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


    /**
     * @author haojunfan
     * @date 2020/10/26 下午4:41
     * @description 更新评论字段内容(点赞)
     **/
    public boolean updateCommentGreatNum(Comment comment) throws SQLException {
        Connection conn = ConnectionUtil.getConnection();
        String sql = "UPDATE comment SET greatNum=? WHERE id = ?";
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, comment.getGreatNum());
            stmt.setInt(2, comment.getId());
            stmt.execute();
        } catch (SQLException e) {
            System.out.println("更新失败。");
            e.printStackTrace();
            return false;
        } finally {
            ConnectionUtil.release(null, stmt, conn);
        }
        return true;
    }

    /**
     * @author haojunfan
     * @date 2020/10/26 下午5:06
     * @description     根据评论ID查询评论
     **/
    public Comment queryCommentById(int commentId) throws SQLException {
        Connection conn = ConnectionUtil.getConnection();
        String sql = "select * from comment where id = ? ";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Comment comment = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, commentId);
            rs = stmt.executeQuery();
            while (rs.next()) {
                comment = new Comment();
                comment.setId(rs.getInt("id"));
                comment.setUserId(rs.getInt("user_id"));
                comment.setUsername(rs.getString("username"));
                comment.setContent(rs.getString("content"));
                comment.setCreateTime(rs.getDate("create_time"));
                comment.setGreatNum(rs.getInt("greatNum"));
            }
        } catch (SQLException e) {
            System.out.println("查询用户信息失败。");
            e.printStackTrace();
        } finally {
            ConnectionUtil.release(rs, stmt, conn);
        }
        return comment;
    }


}



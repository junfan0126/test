package com.cs533.dao;

import com.cs533.Entity.Message;
import com.cs533.db.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class MessageDAO {


        /**
         * 保存评论信息
         * @param message
         * @return
         */
        public boolean save(Message message) {
            Connection conn = null;
            try {
                conn = ConnectionUtil.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            String sql = "insert into message(user_id, username, content) values (?, ?, ?)";
            PreparedStatement stmt = null;
            try {
                stmt = conn.prepareStatement(sql);
                stmt.setInt(1, message.getUserId());
                stmt.setString(2, message.getUsername());
                stmt.setString(3, message.getContent());
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





    }



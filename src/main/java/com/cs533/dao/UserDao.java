package com.cs533.dao;

import com.cs533.Entity.User;
import com.cs533.db.*;

import javax.swing.*;
import java.sql.*;

/**
 * 用户登录
 * @return 返回用户
 */
public class UserDao {
    /**
     * 用户登录
     */
        //数据库连接对象
        public User login(String username, String password) {
            User u = null;
            Connection connection = null;
            PreparedStatement pstmt = null;
            ResultSet resultSet = null;

            //赋值
            try {
                connection = ConnectionUtil.getConnection();
                //静态sql语句
                String sql = "select * from user where username=? and password=?";
                pstmt = (PreparedStatement) connection.prepareStatement(sql);
                pstmt.setString(1, username);
                pstmt.setString(2, password);
                resultSet = pstmt.executeQuery();
                if (resultSet.next()) {
                    u = new User();
                    u.setUser_id(resultSet.getInt("user_id"));
                    u.setUsername(resultSet.getString("username"));
                    u.setPassword(resultSet.getString("password"));
                    u.setNickname(resultSet.getString("nickname"));
                    u.setSex(resultSet.getString("sex"));
                    System.out.println("登录成功！");
                } else {
                    System.out.println("用户名或者密码错误！");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return u;
        }


        /**
         * 根据username查询用户信息
         * @param username
         * @return
         */
        public User getUserByusername(String username) {
            Connection conn = null;
            try {
                conn = ConnectionUtil.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            String sql = "select * from user where user_id = ?";
            PreparedStatement stmt = null;
            ResultSet rs = null;
            User user = null;
            try {
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, username);
                rs = stmt.executeQuery();
                while (rs.next()) {
                    user = new User();
                    user.setUsername(rs.getString("username"));
                    user.setPassword(rs.getString("password"));
                    user.setNickname(rs.getString("nickname"));
                    user.setSex(rs.getString("sex"));
                }
            } catch (SQLException e) {
                System.out.println("查询用户信息失败。");
                e.printStackTrace();
            } finally {
                ConnectionUtil.release(rs, stmt, conn);
            }
            return user;
        }

        /**
         * 修改用户信息
         * @param user
         * @return
         */
        public boolean updateUser(User user) {
            Connection conn = null;
            try {
                conn = ConnectionUtil.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            String sql = "UPDATE user SET username = ?, password = ?, sex = ?, nickname = ? WHERE user_id = ?";
            PreparedStatement stmt = null;
            try {
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, user.getUsername());
                stmt.setString(2, user.getPassword());
                stmt.setString(3, user.getSex());
                stmt.setString(4, user.getNickname());
                stmt.execute();
            } catch (SQLException e) {
                System.out.println("查询用户信息失败。");
                e.printStackTrace();
                return false;
            } finally {
                ConnectionUtil.release(null, stmt, conn);
            }
            return true;
        }


        /**
         * 用户注册
         */
        public void register(String username, String password, String nickname, String sex) {
            Connection conn = null;
            PreparedStatement pstmt = null;


            try {
                conn = ConnectionUtil.getConnection();
                String sql = "insert into user(username,password,nickname,sex) values(?,?,?,?)";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, username);
                pstmt.setString(2, password);
                pstmt.setString(3, nickname);
                pstmt.setString(4, sex);
                pstmt.execute();

            } catch (Exception e) {
                System.out.println("注册失败");
                e.printStackTrace();
            } finally {
                ConnectionUtil.release(null, pstmt, conn);
            }

        }
    }


package com.cs533.db;

import java.sql.*;

public final class ConnectionUtil {
    private static String url = "jdbc:mysql://localhost:3306/jdbctest";
    private static String user = "root";
    private static String password = "haojunfan";

    public ConnectionUtil() {
    }

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("找不到驱动类，驱动加载失败");
            e.printStackTrace();
        }
    }

    /**
     * 获得
     *
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("创建数据库连接失败");
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 释放
     *
     * @param rs
     * @param stmt
     * @param conn
     */
    public static void release(ResultSet rs, Statement stmt, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}

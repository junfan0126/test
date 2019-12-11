package com.cs533.dao;

import com.cs533.Entity.File;
import com.cs533.db.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FileDao {
    /**
     * 保存文件信息
     *
     * @param
     * @return
     */
    public boolean save(File file) {
        Connection conn = null;
        File u = null;
        ResultSet resultSet = null;
        try {
            conn = ConnectionUtil.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql = "insert into file(userId,username,title,creatTime) values (?,?,?,?)";
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, file.getUserId());
            stmt.setString(2, file.getUsername());
            stmt.setString(3, file.getTitle());
            stmt.setDate(4, new Date(System.currentTimeMillis()));
            stmt.execute();
        } catch (Exception e) {
            System.out.println("保存文件信息失败。");
            e.printStackTrace();
            return false;
        } finally {
            ConnectionUtil.release(null, stmt, conn);
        }

        return true;
    }

    /**
     *
     */
    public File login1(int id) {
        File u = null;
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement pstmt = null;

        try {
            connection = ConnectionUtil.getConnection();
            resultSet = pstmt.executeQuery();
            String sql = "select * from file where id=?";
            pstmt = (PreparedStatement) connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            if (resultSet.next()) {
                u = new File();
                u.setUserId(resultSet.getInt("userId"));
                u.setUsername(resultSet.getString("username"));
                u.setTitle(resultSet.getString("title"));


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }


    /**
     * 分页查询
     *
     * @param page     当前页码
     * @param pageSize 每页记录数
     * @return
     */
    public static List<File> getMessages(int page, int pageSize) {
        Connection conn = null;
        try {
            conn = ConnectionUtil.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql = "select * from file order by id desc limit ?,?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<File> files = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, (page - 1) * pageSize);
            stmt.setInt(2, pageSize);
            rs = stmt.executeQuery();
            while (rs.next()) {
                files.add(new File(rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("title"),
                        rs.getDate("creatTime")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.release(rs, stmt, conn);
        }
        return files;
    }

    /**
     * 计算所有文件数量
     *
     * @return
     */
    public int countMessages() {
        Connection conn = null;
        try {
            conn = ConnectionUtil.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql = "select count(*) total from file";
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


//    public List readFirstTitle(){
//        List<File> list =new ArrayList<File>();
//        Connection con=null;
//
//
//        try {
//            con = ConnectionUtil.getConnection();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        String sql="select * from file";
//        PreparedStatement psmt=null;
//        ResultSet rs=null;
//        try {
//            psmt=con.prepareStatement(sql);
//            rs=psmt.executeQuery();
//            while(rs.next())
//            {
//
//
//                String username=rs.getString("username");
//            String title=rs.getString("title");
//            File tl=new File(username, title);
//            list.add(tl);
//        }
//
//    } catch (SQLException e) {
//        e.printStackTrace();
//    }finally
//    {
//        try {
//            if(rs!=null)
//            {
//                rs.close();
//            }
//            if(psmt!=null)
//            {
//                psmt.close();
//            }
//            if(con!=null)
//            {
//                con.close();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//         return list;
//}

















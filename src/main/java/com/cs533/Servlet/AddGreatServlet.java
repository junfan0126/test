package com.cs533.Servlet;

import com.cs533.Entity.Comment;
import com.cs533.Entity.Message;
import com.cs533.Entity.User;
import com.cs533.Service.CommentService;
import com.cs533.Service.MessageService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * @author
 * @version 1.0
 * @date 2020/10/26 下午3:44
 * @description     点赞servlet
 **/

public class AddGreatServlet extends HttpServlet {
    private CommentService commentService;

    @Override
    public void init() throws ServletException {
        super.init();
        commentService = new CommentService();
    }

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("key");
        int commendId = Integer.parseInt(id);
        Comment comment= null;
        try {
            comment = commentService.queryCommentById(commendId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int a=comment.getGreatNum()+1;
        comment.setGreatNum(a);
        boolean result= false;
        try {
            result = commentService.updateCommentGreatNum(comment);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (result) {
            request.getRequestDispatcher("/CommentLIstServlet").forward(request, response);
        } else {
            request.getRequestDispatcher("404.jsp").forward(request, response);
        }
    }


}
//}


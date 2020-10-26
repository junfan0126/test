package com.cs533.Servlet;

import com.cs533.Entity.Comment;

import com.cs533.Entity.Message;
import com.cs533.Entity.User;
import com.cs533.Service.CommentService;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Date;
import java.util.Objects;

/**
 * @author haojunfan
 */
public class CommentServlet extends HttpServlet {

    public CommentService commentService;

    @Override
    public void init() throws ServletException {
        super.init();
        commentService=new CommentService();
    }


    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            User user = (User)request.getSession().getAttribute("user");

            if (null == user) {
                request.getRequestDispatcher("/CommentLIstServlet").forward(request, response);
            } else {
                String content = request.getParameter("content");
                int userId=user.getUser_id();
                String username=user.getUsername();
                Comment comment=new Comment(userId,username,content,new Date());
                System.out.println(comment);
                boolean result= commentService.addComment(comment);
                if (result) {
                    request.getSession().setAttribute("comment",comment);
//                    request.getSession().setAttribute("comment", commentService.queryComment(comment.getUserId(),comment.getCreateTime()));
//                    Comment comment1= (Comment) request.getSession().getAttribute("comment");
                    request.getRequestDispatcher("/CommentLIstServlet").forward(request, response);
                } else {
                    request.getRequestDispatcher("/add_comment.jsp").forward(request, response);
                }
            }
    }


    @Override
    public void destroy() {
        super.destroy();
       commentService =null;
    }
}


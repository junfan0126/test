package com.cs533.Servlet;

import com.cs533.Entity.Comment;
import com.cs533.Entity.Message;
import com.cs533.Entity.User;
import com.cs533.Service.MessageService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.Objects;

/**
 * @author
 * @version 1.0
 * @date 2020/10/26 下午2:09
 * @description
 **/

public class MessageServlet extends HttpServlet {

    private MessageService messageService;

    @Override
    public void init() throws ServletException {
        super.init();
        messageService = new MessageService();
    }

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (null == user) {
            request.getRequestDispatcher("/ListServlet").forward(request, response);
        } else {
            String content = request.getParameter("content");
            String title = request.getParameter("title");
            int userId = user.getUser_id();
            String username = user.getUsername();
            Message message = new Message(userId, username, content, title, new Date());
            System.out.println(message);
            boolean result = false;
            try {
                result = messageService.addMessage(message);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (result) {
                request.getRequestDispatcher("/ListServlet").forward(request, response);
            } else {
                request.getRequestDispatcher("/add_message.jsp").forward(request, response);
            }
        }
    }
}

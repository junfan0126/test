package com.cs533.Servlet;

import com.cs533.Entity.File;
import com.cs533.Entity.Message;
import com.cs533.Entity.User;
import com.cs533.Service.MessageService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Objects;


public class MessageServlet extends HttpServlet {

    public MessageService messageService;

    @Override
    public void init() throws ServletException {
        super.init();
        messageService = new MessageService();
    }


    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



            File file = (File) request.getSession().getAttribute("file");
            String content = request.getParameter("content");
            boolean result = messageService.addMessage(new Message(file.getId(), file.getUsername(), content));
            if (result) {
                request.getRequestDispatcher("/CommentListServlet").forward(request, response);
            } else {
                request.getRequestDispatcher("add_comment.jsp").forward(request, response);
            }




    }

    public void destroy() {
        super.destroy();
        messageService =null;
    }
}


package com.cs533.Servlet;

import com.cs533.Entity.File;
import com.cs533.dao.FileDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet2 {
    public LoginServlet2() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String userid=request.getParameter("id");
        int id = Integer.parseInt(userid);
        FileDao fileDao =new FileDao();
        File file =fileDao.login1(id);
        if (file != null) {
            request.getSession().setAttribute("file", file);
            request.getRequestDispatcher("commentList.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("message_list.jsp").forward(request, response);
        }


    }
}


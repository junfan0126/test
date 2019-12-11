package com.cs533.Servlet;

import com.cs533.Entity.User;
import com.cs533.Service.UserService;
import com.cs533.dao.UserDao;
import com.cs533.db.ConnectionUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * 登录Servlet
 *
 * @version 1.0
 */
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public LoginServlet() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserDao userDAO = new UserDao();
        User user = userDAO.login(username, password);
        if (user != null) {
            request.getSession().setAttribute("user", user);
            request.getRequestDispatcher("/ListServlet").forward(request, response);
        } else {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }


    }
}
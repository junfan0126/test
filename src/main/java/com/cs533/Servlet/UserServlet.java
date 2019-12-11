package com.cs533.Servlet;

import com.cs533.Entity.User;
import com.cs533.Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class UserServlet extends HttpServlet {

    private UserService userService;

    @Override
    public void init() throws ServletException {
        super.init();
        userService = new UserService();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathName = request.getServletPath();
        if (Objects.equals("/userInfo.do", pathName)) {
            request.getRequestDispatcher("user.jsp").forward(request, response);
        } else if (Objects.equals("/UserServlet", pathName)) {

            String username = String.valueOf(request.getParameter("username"));
            User user = userService.getUserByusername(username);
            if (null != user) {
                request.setAttribute("user", user);
                request.getRequestDispatcher("edit_user.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("user.jsp").forward(request, response);
            }
        } else if (Objects.equals("/editUser.do", pathName)) {
            String userid=request.getParameter("user_id");
           int id = Integer.parseInt(userid);
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String nickname = request.getParameter("nickname");
            String sex = request.getParameter("sex");
            User user = new User();
            user.setUser_id(id);
            user.setUsername(username);
            user.setPassword(password);
            user.setNickname(nickname);
            user.setSex(sex);
            boolean result = userService.updateUser(user);
            if (result) {
                request.getSession().setAttribute("user", user);
                request.setAttribute("user", user);
                request.getRequestDispatcher("user.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("404.jsp").forward(request, response);
            }
        }

    }
}


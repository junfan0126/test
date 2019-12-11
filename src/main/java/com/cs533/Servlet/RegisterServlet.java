package com.cs533.Servlet;

import com.cs533.Entity.User;
import com.cs533.dao.UserDao;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





 public class RegisterServlet extends HttpServlet {



     public RegisterServlet() {
         super();
     }

     protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doPost(request, response);
     }

     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


         request.setCharacterEncoding("UTF-8");
         //请求封装参数对应的值
         String username = request.getParameter("username");
         String password = request.getParameter("password");
         String sex = request.getParameter("sex");
         String nickname = request.getParameter("nickname");

         //实列化User对象，封装值
         User user = new User();
         user.setUsername(username);
         user.setPassword(password);
         user.setNickname(nickname);
         user.setSex(sex);


         //实列化数据层
         UserDao userDao = new UserDao();
         userDao.register(username,password,sex,nickname);
         System.out.println("注册成功");
         request.setAttribute("username", username);
         request.getRequestDispatcher("login.jsp").forward(request, response);

     }


 }


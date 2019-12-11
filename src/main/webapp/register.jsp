<%--
  Created by IntelliJ IDEA.
  User: haojunfan
  Date: 2019/12/5
  Time: 上午12:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
     <title>注册页面</title>
     </head>
<body>
   <br><br><br>
   <h3 align = "center">注册页面</h3>
   <hr>
     <form align = "center" action="/RegisterServlet" method="post">
            <table align = "center" border="0">
                 <tr><td>用户名</td><td><input type="text" name="username" ></td></tr>
                 <tr><td>密码</td><td><input type="password" name="password" ></td></tr>
                 <tr><td>昵称</td><td><input type="text" name="nickname" ></td></tr>
                <tr><td>性别</td><td><input type="text" name="sex" ></td></tr>
                 <tr><td align = "center" colspan="2"><input type="submit" value = "注册" style="color:blue" ></td></tr>
            </table>
     </form>
 </body>
 </html>

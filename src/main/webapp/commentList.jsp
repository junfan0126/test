<%--
  Created by IntelliJ IDEA.
  User: haojunfan
  Date: 2019/12/9
  Time: 下午7:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>评论栏</title>
    <link rel="stylesheet" href="../../../css/index.css">

</head>


<section class="banner">
    <div class="container">
        <div>
            <h1>评论栏</h1>

        </div>
    </div>
</section>


<section class="main">
    <div class="container">
        <c:forEach items="${comments}" var="msg">
            <div class="alt-item">
                <div class="alt-head">
                    <div class="alt-info">
                        <span><a href="">${msg.username}</a> 说：</span>
                        <span>时间：<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${msg.createTime}"/></span>
                    </div>
                </div>
                <div class="alt-content">
                    <p>${msg.content}</p>
                    <form action="/AddGreatServlet" method="post" enctype="application/x-www-form-urlencoded" >
                        <input type="text" id="key" name="key" value="${msg.id}" style="display: none" >
                        <button  class="btn-primary">
                            赞👍
                        </button>
                    </form>
                </div>
            </div>
        </c:forEach>
    </div>
</section>


<section class="page">
    <div class="container">
        <% if (null != request.getSession().getAttribute("user")) {%>
        <div id="fatie">
            <a href="add_comment.jsp">
                <button>评论</button>
            </a>
            <a href="/ListServlet">
                <button>返回</button>
            </a>
        </div>
        <%} else { %>
        <div id="fatie">
            请<a href="/login.do">
            <button>登录</button>
        </a>
        </div>
        <% } %>

        <div id="pagefy">
            <ul>
                <form id="messageForm" action="/CommentLIstServlet" method="post">
                    <input type="hidden" id="page" name="page" value="${page}">
                    <input type="hidden" id="last" name="last" value="${last}">
                    <li><a href="javascript:void(0)" onclick="submitMessageForm('first')">首页</a></li>
                    <li><a href="javascript:void(0)" onclick="submitMessageForm('pre')">上一页</a></li>
                    <li><a href="javascript:void(0)">当前第${page}页</a></li>
                    <li><a href="javascript:void(0)" onclick="submitMessageForm('next')">下一页</a></li>
                    <li><a href="javascript:void(0)" onclick="submitMessageForm('last')">尾页</a></li>
                </form>
            </ul>
        </div>

    </div>
</section>
<footer>

</footer>
</body>
</html>
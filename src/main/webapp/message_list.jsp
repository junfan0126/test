<%@ page import="java.util.Iterator" %>
<%@ page import="com.cs533.Entity.File" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.cs533.dao.FileDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
    <head>
        <meta charset="UTF-8">
        <title>文件板</title>
        <link rel="stylesheet" href="../../../css/index.css">
        <script type="text/javascript">
            function submitMessageForm(flag) {
                if ('first' == flag) {
                    document.getElementById('page').value = 1;
                } else if ('pre' == flag) {
                    var current = Number(document.getElementById('page').value);
                    if (current > 1) {
                        document.getElementById('page').value = current - 1;
                    }
                } else if ('next' == flag) {
                    var current = Number(document.getElementById('page').value);
                    var last = Number(document.getElementById('last').value);
                    if (current < last) {
                        document.getElementById('page').value = current + 1;
                    }
                } else if ('last' == flag) {
                    var last = Number(document.getElementById('last').value);
                    document.getElementById('page').value = last < 1 ? 1 : last;
                }
                document.getElementById('messageForm').submit();
            }
        </script>
    </head>

    <body>



        <header>
            <div class="container">
                <% if (null != request.getSession().getAttribute("user")) {%>
                    <nav>
                        <a href="/ListServlet">我的文件</a>
                    </nav>
                    <nav>
                        <a href="/userInfo.do">我的信息</a>
                    </nav>
                <%} else { %>
                    <nav>
                        <a href="/login.do">登录</a>
                        <a href="/RegisterServlet">注册</a>
                    </nav>
                <% } %>
            </div>
        </header>
        <section class="banner">
            <div class="container">
                <div>
                    <h1>文件管理平台</h1>
                </div>
            </div>
        </section>





        <section class="main">
            <div class="container">
                <c:forEach items="${files}" var="msg">
                    <div class="alt-item">
                        <div class="alt-head">
                            <div class="alt-info">
                                <span> 发布人：<a href="">${msg.username}</a></span>
                                <span>发布时间：<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${msg.creatTime}"/></span>
                            </div>
                        </div>
                        <div class="alt-content">
                            <h3>${msg.title}</h3>
                            <a href="javascript:void(0)" >comment</a>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </section>


        <section class="page">
            <div class="container">
                <% if (null != request.getSession().getAttribute("user")) {%>

                <div id="fatie">
                    <a href="add_message.jsp"><button>点我上传</button></a>
                </div>

                <%} else { %>
                    <div id="fatie">
                        请<a href="/login.do"><button>登录</button></a>后发布
                    </div>
                <% } %>


                <div id="pagefy">
                    <ul>
                        <form id="messageForm" action="/ListServlet" method="post">
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
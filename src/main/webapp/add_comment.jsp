<%--
  Created by IntelliJ IDEA.
  User: haojunfan
  Date: 2019/12/9
  Time: 下午8:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>新建留言</title>
    <link rel="stylesheet" href="../../../css/bootstrap.min.css">
    <link rel="stylesheet" href="../../../css/add.css">
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="/MessageServlet">
                想说什么就说什么
            </a>
        </div>
    </div>
</nav>
<div class="container">
    <div class="jumbotron">
        <h1>Hello, ${user.username}!</h1>

    </div>
    <div class="page-header">
        <h3><small>新建评论</small></h3>
    </div>
    <form class="form-horizontal" action="/CommentServlet" method="post">

        <div class="form-group">
            <label for="inputContent" class="col-sm-2 control-label">内容 ：</label>
            <div class="col-sm-8">
                <textarea name="content"  class="form-control" rows="3" id="inputContent" placeholder="Content"></textarea>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-primary">发表评论</button>&nbsp;&nbsp;&nbsp;
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <a class="btn btn-default" href="/CommentListServlet">查看评论</a>
            </div>
        </div>
    </form>
</div>
<footer class="text-center" >
   想说就说
</footer>
</body>
</html>

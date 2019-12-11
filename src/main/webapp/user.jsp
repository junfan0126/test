<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta charset="UTF-8">
        <title>我的信息</title>
        <link rel="stylesheet" href="../../../css/bootstrap.min.css">
        <link rel="stylesheet" href="../../../css/add.css">
    </head>
    <body>
        <nav class="navbar navbar-default">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="/ListServlet">
                        返回
                    </a>
                </div>
            </div>
        </nav>
        <div class="container">
            <div class="jumbotron">
                <h1>Hello, ${user.username}!</h1>
                <p>信息都在这里了 ^_^</p>
            </div>
            <div class="page-header">
                <h3><small>个人信息</small></h3>
            </div>
            <form class="form-horizontal" action="/UserServlet" method="post">
                <input type="hidden" id="id" name="id" value="${user.user_id}">

                <div class="form-group">
                    <label for="nickname" class="col-sm-2 control-label">昵称 ：</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" id="nickname" value="${user.nickname}" readonly>
                    </div>
                </div>

                <div class="form-group">
                    <label for="username" class="col-sm-2 control-label">姓名 ：</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" id="username" value="${user.username}" readonly>
                </div>
                </div>

                <div class="form-group">
                    <label for="sex" class="col-sm-2 control-label">性别 ：</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" id="sex" value="${user.sex}" readonly>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-primary">修改</button>&nbsp;&nbsp;&nbsp;
                    </div>
                </div>

            </form>
        </div>
        <footer class="text-center" >
        </footer>
    </body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta charset="UTF-8">
        <title>新建文件</title>
        <link rel="stylesheet" href="../../../css/bootstrap.min.css">
        <link rel="stylesheet" href="../../../css/add.css">

    </head>
    <body>
        <nav class="navbar navbar-default">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="/ListServlet">
                        文件展览
                    </a>
                </div>
            </div>
        </nav>
        <div class="container">
            <div class="jumbotron">
                <h1>Hello, ${user.username}!</h1>
                <p>既然来了，那就留点东西吧</p>
            </div>



            <form class="form-horizontal" action="/addMessage.do" enctype="multipart/form-data" method="post">
                <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <input type="file" name="file"/>
                    <input type="submit" class="btn btn-primary" value="上传文件">
                </div>
            </div>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <a class="btn btn-default" href="/ListServlet">查看文件</a>
                    </div>
                </div>

            </form>
        </div>
        <footer class="text-center" >

        </footer>
    </body>
</html>

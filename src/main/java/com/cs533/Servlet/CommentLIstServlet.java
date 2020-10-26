package com.cs533.Servlet;

import com.cs533.Entity.Comment;
import com.cs533.Entity.File;
import com.cs533.Service.CommentService;
import com.cs533.Service.FileService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author haojunfan
 */
public class                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     CommentLIstServlet extends HttpServlet {
    private CommentService commentService;

    @Override
    public void init() throws ServletException {
        super.init();
        commentService = new CommentService();
    }


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageStr = req.getParameter("page");
        int page = 1;
        if (null != pageStr && (!"".equals(pageStr))) {
            try {
                page = Integer.parseInt((pageStr));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }


        List<Comment> comments =CommentService.getComment(page, 5);
        int count = commentService.countComment();
        int last = count % 5 == 0 ? (count / 5) : ((count / 5) + 1);
        req.setAttribute("last", last);
        req.setAttribute("comments", comments);
        req.setAttribute("page", page);
        req.getRequestDispatcher("commentList.jsp").forward(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
        commentService= null;
    }
}

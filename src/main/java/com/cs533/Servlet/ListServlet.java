package com.cs533.Servlet;

import com.cs533.Entity.File;
import com.cs533.Service.FileService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListServlet extends HttpServlet {
    private FileService fileSerivce;

    @Override
    public void init() throws ServletException {
        super.init();
        fileSerivce = new FileService();
    }


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

        List<File> files = FileService.getMessages(page, 5);
        int count = fileSerivce.countMessages();
        int last = count % 5 == 0 ? (count / 5) : ((count / 5) + 1);
        req.setAttribute("last", last);
        req.setAttribute("files", files);
        req.setAttribute("page", page);
        req.getRequestDispatcher("message_list.jsp").forward(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
        fileSerivce = null;
    }
}

package com.cs533.Servlet;

import com.cs533.Entity.File;
import com.cs533.dao.BadWordUtil2;
import com.cs533.db.UploadUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cs533.Entity.User;
import com.cs533.Service.FileService;

import java.io.*;
import java.util.*;


/**
 * 文件上传Servlet
 */

public class FileServlet extends HttpServlet {
    private FileService fileService;


    @Override
    public void init() throws ServletException {
        super.init();
        fileService = new FileService();
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathName = request.getServletPath();
        if (Objects.equals("/addMessagePrompt.do", pathName)) {
            request.getRequestDispatcher("add_message.jsp").forward(request, response);
        } else if (Objects.equals("/addMessage.do", pathName)) {
            User user = (User) request.getSession().getAttribute("user");
            if (null == user) {
                request.getRequestDispatcher("/ListServlet").forward(request, response);
            } else {
                DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
                ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
                List<FileItem> list = null;
                try {
                    list = servletFileUpload.parseRequest(request);
                } catch (FileUploadException e) {
                    e.printStackTrace();
                }

                for (FileItem fileItem : list) {
                    if (fileItem.isFormField()) {
                        String name = fileItem.getFieldName();
                        String value = fileItem.getString("UTF-8");
                        System.out.println(name + "    " + value);
                    }
                    String fileName = fileItem.getName();
                    if (fileName != null && !"".equals(fileName)) {
                        boolean result = fileService.addMessage(new File(user.getUser_id(), user.getUsername(), fileName, new Date()));
                        if (!result) {
                            request.getRequestDispatcher("/404.jsp").forward(request, response);
                            return;
                        }

                        String uuidFileName = UploadUtils.getUUIDFileName(fileName);
                        InputStream is = fileItem.getInputStream();
                        String path = this.getServletContext().getRealPath("/test");
                        String url = path + "/" + uuidFileName;
                        OutputStream os = new FileOutputStream(url);
                        int len = 0;
                        byte[] b = new byte[1024];
                        while ((len = is.read(b)) != -1) {
                            os.write(b, 0, len);
                        }
                        is.close();
                        os.close();


                        StringBuffer buffer = new StringBuffer();
                        BufferedReader bf = new BufferedReader(new FileReader(url));
                        String s = null;
                        while ((s = bf.readLine()) != null) {//使用readLine方法，一次读一行
                            buffer.append(s.trim());
                        }

                        Map<String, String> map = BadWordUtil2.wordMap;

                        String xml = buffer.toString();
                        Set<String> set = BadWordUtil2.getBadWord(xml, 2);
                        xml = BadWordUtil2.replaceBadWord(xml, 2, "*");

                        FileWriter fwriter = null;
                        try {
                            fwriter = new FileWriter(url);
                            fwriter.write(xml);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        } finally {
                            try {
                                fwriter.flush();
                                fwriter.close();
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                        }
                        //下行代码可在服务端查看是否检测和替换敏感词是否执行
                        //System.out.println("语句中包含敏感词的个数为：" + set.size() + "。包含：" + set+xml);
                    }
                    request.getRequestDispatcher("/ListServlet").forward(request, response);

                }
            }
        }
    }
}





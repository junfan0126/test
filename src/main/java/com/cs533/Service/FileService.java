package com.cs533.Service;

import com.cs533.Entity.File;
import com.cs533.dao.FileDao;

import java.util.List;

public class FileService {
    private FileDao fileDao;

    public FileService() {
        fileDao = new FileDao();
    }
    public boolean addMessage(File file) {

        return fileDao.save(file);
    }
    /**
     * 分页查询全部文件
     *
     * @param page     当前页码
     * @param pageSize 每页记录数
     * @return
     */
    public static List<File> getMessages(int page, int pageSize) {
        return FileDao.getMessages(page, pageSize);
    }

    /**
     * 计算所有文件数量
     *
     * @return
     */

    public int countMessages() {
        return fileDao.countMessages();
    }


}

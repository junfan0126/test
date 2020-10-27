package com.cs533.Service;

import com.cs533.Entity.Message;
import com.cs533.dao.MessageDao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * @author
 * @version 1.0
 * @date 2020/10/26 下午1:30
 * @description
 **/

public class MessageService {

    private MessageDao messageDao;

    public MessageService() {
        messageDao = new MessageDao();
    }

    public boolean addMessage(Message message) throws SQLException {
        message.setCreateTime(new Date());
        return messageDao.save(message);
    }

    /**
     * 分页查询全部留言
     * @param page 当前页码
     * @param pageSize 每页记录数
     * @return
     */
    public List<Message> getMessages(int page, int pageSize) throws SQLException {
        return messageDao.getMessages(page, pageSize);
    }

    /**
     * 计算所有留言数量
     * @return
     */
    public int countMessages() throws SQLException {
        return messageDao.countMessages();
    }


}

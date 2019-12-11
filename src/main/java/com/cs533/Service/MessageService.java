package com.cs533.Service;

import com.cs533.Entity.Message;
import com.cs533.dao.MessageDAO;

import java.util.Date;


public class MessageService {
    private MessageDAO messageDAO;

    public MessageService() {
        messageDAO = new MessageDAO();
    }

    public boolean addMessage(Message message) {
        message.setCreateTime(new Date());
        return messageDAO.save(message);
    }



}

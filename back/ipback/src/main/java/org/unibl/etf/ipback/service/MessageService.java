package org.unibl.etf.ipback.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unibl.etf.ipback.entities.MessageEntity;
import org.unibl.etf.ipback.repository.MessageRepositroy;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageRepositroy messageRepositroy;

    public List<MessageEntity> getAllUnreadMessage(){
        List<MessageEntity> lists = messageRepositroy.findAll();
        ArrayList<MessageEntity> listUnreadMessage = new ArrayList<>();
        for(MessageEntity message : lists){
            if(message.getIsRead() == 0)
                listUnreadMessage.add(message);
        }
        return listUnreadMessage;
    }

    public void createMessage(MessageEntity messageEntity){
        messageRepositroy.save(messageEntity);
    }
}

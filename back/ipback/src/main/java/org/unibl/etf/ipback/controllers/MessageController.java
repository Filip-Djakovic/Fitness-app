package org.unibl.etf.ipback.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.unibl.etf.ipback.entities.MessageEntity;
import org.unibl.etf.ipback.service.MessageService;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @GetMapping
    public List<MessageEntity> getAllMessage(){
        return messageService.getAllUnreadMessage();
    }

    @PostMapping
    public ResponseEntity<?> createMessage(@RequestBody MessageEntity messageEntity){
        messageService.createMessage(messageEntity);
        return ResponseEntity.status(HttpStatusCode.valueOf(204)).build();
    }
    @PutMapping
    public ResponseEntity<?> updateMessage(@RequestBody MessageEntity messageEntity){
        messageService.createMessage(messageEntity);
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).build();
    }
}


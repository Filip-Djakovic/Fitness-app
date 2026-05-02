package org.unibl.etf.ipback.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.ipback.entities.EmailEntity;
import org.unibl.etf.ipback.service.EmailService;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping
    public ResponseEntity<?> sendEmail(@RequestBody String mess){
        emailService.sendMail("filip.djakovic@student.etf.unibl.org",mess);
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).build();
    }

    @PostMapping("/email_picture")
    public ResponseEntity<?> sendEmailWithPicture(@RequestBody EmailEntity emailEntity){
        emailService.sendMailWithPicture("filip.djakovic@student.etf.unibl.org", emailEntity);

        return ResponseEntity.status(HttpStatusCode.valueOf(200)).build();
    }
}

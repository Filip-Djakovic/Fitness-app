package org.unibl.etf.ipback.service;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.unibl.etf.ipback.entities.EmailEntity;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;
    public void sendMail(String to, String mess){
        try{
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(to);
            helper.setSubject("Obavjestenje");
            helper.setText(mess, true);
            javaMailSender.send(message);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public void sendMailWithPicture(String to, EmailEntity emailEntity){
        try{
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(to);
            helper.setSubject("Obavjestenje");
            helper.setText(emailEntity.getMess(), true);
            //Path path = Paths.get(emailEntity.getPath());
            System.out.println(emailEntity.getPath());
            FileSystemResource file = new FileSystemResource(new File(emailEntity.getPath()));
            helper.addAttachment(file.getFilename(), file);

            javaMailSender.send(message);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}

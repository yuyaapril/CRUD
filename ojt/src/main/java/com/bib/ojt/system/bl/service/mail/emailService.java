
package com.bib.ojt.system.bl.service.mail;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class emailService {

    @Autowired
    JavaMailSender javaMailSender;

    public void sendEmail(String toEmail) throws MessagingException {
        //todo1 Message Configuration
        SimpleMailMessage message = new SimpleMailMessage();
        //Sending Text Mail Only
        message.setFrom("yunandarhlaing.yndh@gmail.com");
        message.setTo(toEmail);
        message.setSubject("Mail Sub Title");
        message.setText("Body Message");
        //message ဆိုတဲ့ configuration ချပြီးသွားရင် javaMailSenderကိုသုံးပြီး .send/...
        javaMailSender.send(message);
        //html , attach files

    }
}

package com.bib.ojt.system.web.controller.email;

import com.bib.ojt.system.bl.service.mail.emailService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email")
public class EmailController {

    @Autowired
    private emailService emailService;

    @GetMapping("/send")
    public String sendEmail(@RequestParam String toEmail){
        try{
            emailService.sendEmail(toEmail);
            return "Email sent successfully to " + toEmail;
        }catch (MessagingException e){
            e.printStackTrace();
            return "Failed to send email" + e.getMessage();
        }
    }
}

//import com.bib.ojt.system.bl.service.mail.emailService;
//import jakarta.mail.MessagingException;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api/email")
//public class EmailController {
//    public static final Logger logger = LoggerFactory.getLogger(EmailController.class);
//
//    @Autowired
//    private emailService emailService;
//
//    @PostMapping("/send")
//    public String sendEmail(@RequestParam String toEmail){
//        try{
//            emailService.sendEmail(toEmail);
//            return "Email sent successfully to " + toEmail;
//        }catch (MessagingException e){
//            logger.error("Failed to send email to {} : {}" , toEmail, e.getMessage(), e);
//            return "Failed to send email: " + e.getMessage();
//        }
//    }
//}
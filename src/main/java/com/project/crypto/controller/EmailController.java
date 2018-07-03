package com.project.crypto.controller;

import com.project.crypto.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final EmailService emailService;

    @Value("${spring.mail.username}")
    private String emailAddress;

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @RequestMapping("/send-reminder")
    public void sendEmail() {
        logger.debug("preparing to send an email");
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(emailAddress);
        simpleMailMessage.setTo(emailAddress);
        simpleMailMessage.setSubject("Reminder");
        simpleMailMessage.setText("");

        try {
            emailService.sendEmail(simpleMailMessage);
        } catch (MailException ex) {
            logger.error(ex.getMessage());
        }
        logger.debug("Email sent");
    }

}

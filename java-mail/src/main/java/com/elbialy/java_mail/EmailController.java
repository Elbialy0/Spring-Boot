package com.elbialy.java_mail;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

@RestController
public class EmailController {
    @Autowired
    public JavaMailSender mailSender;
    @RequestMapping("/send-email")
    public String sendEmail() {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("mr9892374@gmail.com");
            message.setTo("mahmoudelbialy49@gmail.com");
            message.setSubject("test email");
            message.setText("hello bialy this is a test email");
            mailSender.send(message);
            return "success";
        } catch (MailException mailException){
            return mailException.getMessage();
        }

    }

    @RequestMapping("/send-email-with-attachment")
    public String sendEmailWithAttachment() throws MessagingException {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom("mr9892374@gmail.com");
            helper.setTo("mahmoudelbialy49@gmail.com");
            helper.setSubject("test email");
            helper.setText("Attachment");
            helper.addAttachment("Screenshot_from_2025-02-01_13-10-59.webp",new File("C:\\Users\\mr989\\OneDrive\\Desktop\\Screenshot_from_2025-02-01_13-10-59.webp"));

            mailSender.send(message);
            return "success";
        } catch (MailException mailException){
            return mailException.getMessage();
        }
    }
    @RequestMapping("/send-email-with-html-body")
    public String sendEmailWithHtmlBody() throws MessagingException {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom("mr9892374@gmail.com");
            helper.setTo("mahmoudelbialy49@gmail.com");
            helper.setSubject("test email");

            try (var inputStream = Objects.requireNonNull(EmailController.class
                    .getResourceAsStream("/templates/email-content.html")) ) {
                helper.setText(new String(inputStream.readAllBytes()), true);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            helper.addAttachment("Screenshot_from_2025-02-01_13-10-59.webp",new File("C:\\Users\\mr989\\OneDrive\\Desktop\\Screenshot_from_2025-02-01_13-10-59.webp"));

            mailSender.send(message);
            return "success";
        } catch (MailException mailException){
            return mailException.getMessage();
        }
    }
}

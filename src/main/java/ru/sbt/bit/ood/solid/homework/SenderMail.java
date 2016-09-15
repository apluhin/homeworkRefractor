package ru.sbt.bit.ood.solid.homework;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

public class SenderMail {

    public void send(String htmlForm, String recipients) {
        try {
            JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
            mailSender.setHost("mail.google.com");
            // construct the message
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = null;
            helper = new MimeMessageHelper(message, true);
            helper.setTo(recipients);
            // setting message text, last parameter 'true' says that it is HTML format
            helper.setText(htmlForm, true);
            helper.setSubject("Monthly department salary report");
            // send the message
            mailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException("Error during send message", e);
        }
    }
}

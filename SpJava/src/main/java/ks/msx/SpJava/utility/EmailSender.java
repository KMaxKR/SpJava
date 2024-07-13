package ks.msx.SpJava.utility;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailSender{
    private final JavaMailSender emailSender;

    @Value("${spring.mail.username}")
    private String from;

    public void sendMSG(String to, String subject, String msg){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(msg);
        try {
            emailSender.send(message);
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println("Message send");
    }

}

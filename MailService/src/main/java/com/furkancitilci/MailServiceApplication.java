package com.furkancitilci;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MailServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(MailServiceApplication.class);
        
    }

    // Deneme amaçlı kod
//    private final JavaMailSender javaMailSender;
//
//    public MailServiceApplication(JavaMailSender javaMailSender) {
//        this.javaMailSender = javaMailSender;
//    }
//    @Value("${spring.mail.username}")
//    private String mymail;
//
//    @EventListener(ApplicationReadyEvent.class)
//    public void sendMail(){
//        SimpleMailMessage mailMessage=new SimpleMailMessage();
//        mailMessage.setFrom("${mailusername}");
//        mailMessage.setTo("musty1406@gmail.com");
//        mailMessage.setSubject("Aktivasyon kodunuz: ");
//        mailMessage.setText("123548");
//        javaMailSender.send(mailMessage);
//    }
}
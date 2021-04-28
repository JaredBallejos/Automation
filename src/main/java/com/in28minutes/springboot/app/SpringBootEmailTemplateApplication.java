package com.in28minutes.springboot.app;


import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.in28minutes.springboot.services.EmailSenderService;
import com.in28minutes.springboot.model.Mail;
import com.in28minutes.springboot.model.Item;
@SpringBootApplication
@ComponentScan("com.in28minutes.springboot.services")
public class SpringBootEmailTemplateApplication implements ApplicationRunner{
  
  @Autowired
    private EmailSenderService emailService;
  
  private static Logger log = LoggerFactory.getLogger(SpringBootEmailTemplateApplication.class); 
  
  public static void main(String[] args) {
    SpringApplication.run(SpringBootEmailTemplateApplication.class, args);
  }
  @Override
  public void run(ApplicationArguments args) throws Exception {
    
    log.info("START... Sending email");
        Mail mail = new Mail();
        mail.setFrom("jmballejos@gmail.com");//replace with your desired email
        mail.setMailTo("jared.ballejos.2020@gmail.com");//replace with your desired email
        mail.setSubject("Email with Spring boot and thymeleaf template!");
        List < Item > items = new ArrayList < > ();
        items.add(new Item("John", "Cena", "john@gmail.com"));
        items.add(new Item("Tom", "Cruise", "tom@gmail.com"));
        items.add(new Item("Tony", "Stark", "tony@gmail.com"));
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("items", items);
        mail.setProps(model);
        emailService.sendEmail(mail);
        log.info("END... Email sent success");
    
  }
}

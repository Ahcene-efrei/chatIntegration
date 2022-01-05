package fr.efrei.notcensuredchat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class NotCensuredChatApplication {

    public static void main(String[] args) {
//        SpringApplication.run(NotCensuredChatApplication.class, args);
		ApplicationContext context = new ClassPathXmlApplicationContext("ctx.xml");
    }

}

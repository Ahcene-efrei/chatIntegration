package fr.efrei.notcensuredchat;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class NotCensuredChatApplication {

    public static void main(String[] args) {

        // ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        //ApplicationContext ctx = new ClassPathXmlApplicationContext("serviceActivator.xml");

        //ApplicationContext ctx = new ClassPathXmlApplicationContext("routing.xml");

        ApplicationContext ctx = new ClassPathXmlApplicationContext("message.xml");

		/*
		ApplicationContext ctx = new ClassPathXmlApplicationContext("javaScriptService.xml");
		MyGateway myGateway= (MyGateway)ctx.getBean("gateWayService");
		myGateway.method("Salut !");
		*/


		/*ApplicationContext ctx = new ClassPathXmlApplicationContext("webServiceCalling.xml");
		MyGateway myGateway= (MyGateway)ctx.getBean("gateWayService");
		myGateway.method("Salut !");*/



		/*ApplicationContext ctx = new ClassPathXmlApplicationContext("database.xml");
		PersonService personService = ctx.getBean(PersonService.class);
		
		Person person = new Person();
		person.setName("Tintin");
		person = personService.createPerson(person);
		System.out.println(person);*/


    }

}
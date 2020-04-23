package com.smalltalk.hyb.spring.boot.pro;

import com.smalltalk.hyb.spring.boot.pro.Entity.Person;
import com.smalltalk.hyb.spring.boot.pro.component.PersonComonent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class},scanBasePackages = {"com.smalltalk.hyb.spring.boot.*"})
public class ServiceApplicationMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(ServiceApplicationMain.class, args);

        Person person = (Person) applicationContext.getBean("person");

        System.out.println(person.getName());

        PersonComonent personComonent = (PersonComonent) applicationContext.getBean("personComonent");

        System.out.println(personComonent.getName());
    }
}

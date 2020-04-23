package com.smalltalk.hyb.spring.boot.pro.configuration;


import com.smalltalk.hyb.spring.boot.pro.Entity.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EntityConfiguration {

    @Bean(name = "person")
    public Person initPerson() {
        Person person = new Person();
        person.setName("周茹");
        person.setAge(18);
        return person;
    }
}

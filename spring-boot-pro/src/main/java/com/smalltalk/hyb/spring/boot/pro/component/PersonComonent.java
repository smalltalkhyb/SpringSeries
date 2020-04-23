package com.smalltalk.hyb.spring.boot.pro.component;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("personComonent")
@Data
public class PersonComonent {

    @Value("周润发")
    private String name;

    @Value("11")
    private int age;
}

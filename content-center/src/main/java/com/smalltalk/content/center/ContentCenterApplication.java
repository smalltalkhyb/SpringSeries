package com.smalltalk.content.center;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ContentCenterApplication {


    public static void main(String[] args) {
        SpringApplication.run(ContentCenterApplication.class, args);
    }
}

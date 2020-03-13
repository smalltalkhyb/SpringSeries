package com.smalltalk.hyb.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleMain {

    public static void main(String[] args) {

        System.out.println("现在开始初始化容器");

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");

        System.out.println("加载beans配置文件，初始化容器成功！");

        OrderInfo orderInfo = applicationContext.getBean("orderInfo", OrderInfo.class);

        System.out.println(orderInfo);

        System.out.println("开始关闭容器");

        ((ClassPathXmlApplicationContext) applicationContext).registerShutdownHook();

    }
}



package com.smalltalk.hyb.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

import java.math.BigDecimal;

public class OrderInfo implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {

    private Long id;
    private String name;
    private BigDecimal price;
    private BeanFactory beanFactory;
    private String beanName;

    public OrderInfo() {
        System.out.println("构造器 ：调用OrderInfo 的构造器实例化");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("注入属性 name");
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
        System.out.println("注入属性id");
    }


    public BigDecimal getPrice() {
        return price;
    }


    public void setPrice(BigDecimal price) {
        System.out.println("注入属性 price");
        this.price = price;
    }

    //实现BeanFactoryAware接口的setBeanFactory方法
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryAware接口  调用 setBeanFactory方法");
        this.beanFactory = beanFactory;
    }

    //实现 BeanNameAware接口的 setBeanName方法
    public void setBeanName(String beanName) {
        System.out.println("BeanNameAware接口 调用 setBeanName方法");
        this.beanName = beanName;
    }

    //这是InitializingBean接口的afterPropertiesSet方法
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitiallizingBean接口的 afterPropertiesSet 方法");
    }

    //这是DisposableBean 接口的destroy方法
    public void destroy() throws Exception {
        System.out.println("DisposableBean接口的 destroy方法");
    }

    //通过<bean> 的init-method 属性指定初始化方法
    public void orderInfoInit() {
        System.out.println(" init-method 调用<bean>的init-method属性指定的初始化方法");
    }

    //通过<bean> 的destroy-method 属性指定的初始化方法
    public void orderInfoDestory() {
        System.out.println("destory-method 调用<bean> 的 destroy-method 属性指定初始化方法");
    }


}




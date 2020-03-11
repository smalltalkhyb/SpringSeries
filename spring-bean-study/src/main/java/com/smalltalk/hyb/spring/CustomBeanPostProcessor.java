package com.smalltalk.hyb.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class CustomBeanPostProcessor implements BeanFactoryPostProcessor {

    public CustomBeanPostProcessor() {
        super();
        System.out.println(" BeanFactoryPostProcessor实现类构造器");
    }


    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println("BeanFacotryPostProcessor调用postProcessBeanFactory方法");

        BeanDefinition beanDefinition = configurableListableBeanFactory.getBeanDefinition("orderInfo");

        beanDefinition.getPropertyValues().addPropertyValue("price", "100.00");
    }

}

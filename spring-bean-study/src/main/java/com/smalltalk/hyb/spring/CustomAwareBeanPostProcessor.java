package com.smalltalk.hyb.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

import java.beans.PropertyDescriptor;

public class CustomAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {


    public CustomAwareBeanPostProcessor() {
        super();

        System.out.println("这是InstantiationAwareBeanPostProcessorAdapter 实现类构造器！！！");
    }

    //接口方法、实例化Bean之前调用
    @Override
    public Object postProcessBeforeInstantiation(Class beanClass, String beanName) throws BeansException {

        System.out.println("InstantiationAwareBeanPost调用postProcessBeforeInstantiation方法");
        return null;
    }

    //接口方法  实例化Bean 之后调用

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("InstantiationAwareBeanPostProcessor调用postProcessAfterInitialization方法");
        return bean;
    }

    //接口方法  设置某个属性时调用
    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] psd,
                                                    Object bean, String beanName) throws BeansException {
        System.out.println("InstantiationAwareBeanPostProcessor调用postProcessPropertyValues方法");
        return pvs;
    }
}

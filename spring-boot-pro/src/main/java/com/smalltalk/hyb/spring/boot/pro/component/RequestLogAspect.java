package com.smalltalk.hyb.spring.boot.pro.component;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RequestLogAspect {

    private static final Logger log = LoggerFactory.getLogger(RequestLogAspect.class);
    static ThreadLocal<Long> startTime = new ThreadLocal();

    public RequestLogAspect() {

    }

    @Pointcut("execution(public *  com.smalltalk.hyb.spring.boot.pro.controller..*.*(..))")
    public void webLog() {
        System.out.println("我是 doWriteLog-------------------");
        log.info("tttttt");
    }

    @Before("webLog()")
    public void doBefore() {
        System.out.println("我是 doBefore-------------------");
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) {
        System.out.println("我是 doAfterReturning-------------------" + ret);
    }

}

package com.smalltalk.hyb.spring.ratelimit;

import com.google.common.util.concurrent.RateLimiter;
import com.smalltalk.hyb.spring.utils.DateUtil;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TokenLimit {

    private static final int THREAD_COUNT = 25;

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);


        final RateLimiter rateLimiter = RateLimiter.create(1000);
        for (; ; ) {
            executorService.execute(new Runnable() {
                public void run() {
                    rateLimiter.acquire(1);
                    System.out.println(Thread.currentThread().getName()
                            + "获取到了令牌，时间 = " + DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
                }
            });
        }
    }
}

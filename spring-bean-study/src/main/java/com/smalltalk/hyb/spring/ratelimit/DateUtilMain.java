package com.smalltalk.hyb.spring.ratelimit;

import com.smalltalk.hyb.spring.utils.DateUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DateUtilMain {



    public static void main(String[] args) {

          final  SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        ExecutorService executorService = Executors.newFixedThreadPool(100);

        for (;;) {
            executorService.execute(new Runnable() {
                public void run() {
                    try {
                       System.out.println(simpleDateFormat.parse("2017-12-20"));
                       // System.out.println(DateUtil.parse("2017-12-20","yyyy-MM-dd"));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }


    }
}

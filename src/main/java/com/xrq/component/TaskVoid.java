package com.xrq.component;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.Future;

@Component
public class TaskVoid {

    public static Random random = new Random();



    public void doTask() throws Exception {
        System.out.println("开始做任务一");
        long start = System.currentTimeMillis();
        Thread.sleep(10000);
        long end = System.currentTimeMillis();
        System.out.println("完成任务一，耗时：" + (end - start) + "毫秒");
        doTaskOne();
    }


    @Async
    public void doTaskOne() throws Exception {
        System.out.println("开始做任务一");
        long start = System.currentTimeMillis();
        Thread.sleep(10000);
        long end = System.currentTimeMillis();
        System.out.println("完成任务一，耗时：" + (end - start) + "毫秒");
    }

    @Async
    public void doTaskTwo() throws Exception {
        System.out.println("开始做任务二");
        long start = System.currentTimeMillis();
        Thread.sleep(10000);
        long end = System.currentTimeMillis();
        System.out.println("完成任务二，耗时：" + (end - start) + "毫秒");
    }

    @Async
    public void doTaskThree() throws Exception {
        System.out.println("开始做任务三");
        long start = System.currentTimeMillis();
        Thread.sleep(10000);
        long end = System.currentTimeMillis();
        System.out.println("完成任务三，耗时：" + (end - start) + "毫秒");
    }
}
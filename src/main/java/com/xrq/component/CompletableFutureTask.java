package com.xrq.component;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class CompletableFutureTask {


    @Async
    public CompletableFuture<String> doTaskOne() throws Exception {
        System.out.println("开始做任务一");
        long start = System.currentTimeMillis();
        Thread.sleep(10000);
        long end = System.currentTimeMillis();
        System.out.println("CompletableFutureTask完成任务一，耗时：" + (end - start) + "毫秒");
        return CompletableFuture.completedFuture("CompletableFutureTask任务一完成");
    }

    @Async
    public CompletableFuture<String> doTaskTwo() throws Exception {
        System.out.println("开始做任务二");
        long start = System.currentTimeMillis();
        Thread.sleep(10000);
        long end = System.currentTimeMillis();
        System.out.println("CompletableFutureTask完成任务二，耗时：" + (end - start) + "毫秒");
        return CompletableFuture.completedFuture("CompletableFutureTask任务二完成");
    }


    @Async
    public CompletableFuture<String> doTaskThree() throws Exception {
        System.out.println("开始做任务三");
        long start = System.currentTimeMillis();
        Thread.sleep(10000);
        long end = System.currentTimeMillis();
        System.out.println("CompletableFutureTask完成任务三，耗时：" + (end - start) + "毫秒");
        return CompletableFuture.completedFuture("CompletableFutureTask任务三完成");
    }

}
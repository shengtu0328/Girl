package com.xrq.controller;


import com.xrq.component.CompletableFutureTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
public class CompletableFutureController {


    @Autowired
    private CompletableFutureTask task;


    @GetMapping(value = "/CompletableFutureasynctest")
    public void test() throws Exception {

        long start = System.currentTimeMillis();

        CompletableFuture.allOf(task.doTaskOne(), task.doTaskTwo(), (task.doTaskThree())
        ).join();
        long end = System.currentTimeMillis();

        System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");

    }


}

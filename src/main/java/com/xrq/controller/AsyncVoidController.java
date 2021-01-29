package com.xrq.controller;


import com.xrq.component.Task;
import com.xrq.component.TaskVoid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

@RestController
public class AsyncVoidController {


    @Autowired
    private TaskVoid asyncTest;


    @GetMapping(value = "/asyncvoidtest")
    public void test() throws Exception {

        long start = System.currentTimeMillis();

        asyncTest.doTaskOne();
        asyncTest.doTaskTwo();
        asyncTest.doTaskThree();

        long end = System.currentTimeMillis();

        System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");

    }



    @GetMapping(value = "/asyncvoidtest2")
    public void test2() throws Exception {

        long start = System.currentTimeMillis();

        asyncTest.doTask();

        long end = System.currentTimeMillis();

        System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");

    }






}

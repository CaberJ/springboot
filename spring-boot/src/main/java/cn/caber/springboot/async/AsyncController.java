package cn.caber.springboot.async;

import cn.caber.springboot.async.AsyncDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@RestController
@RequestMapping("/async")
public class AsyncController {

    @Autowired
    AsyncDemo asyncDemo;

    @GetMapping("/void")
    public String test1(){
        System.out.println("主线程："+Thread.currentThread().getName());
        asyncDemo.test1();
        return "success";
    }

    @GetMapping("/test2")
    public void test2(){
        System.out.println("主线程："+Thread.currentThread().getName());
        ListenableFuture<String> future = asyncDemo.test2();
        String s = "";
        try {
            s = future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("主线程："+Thread.currentThread().getName()+"结束");

    }

}

package cn.caber.springboot.async;


import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.Future;

@Component
public class AsyncDemo {

    @Async("myAsyncExecutor")
    public  void test1(){
        System.out.println("异步线程"+Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("异步任务正在执行");
    }

    @Async("myAsyncExecutor")
    public ListenableFuture<String> test2(){
        System.out.println("异步线程"+Thread.currentThread().getName());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("异步任务正在执行");
        ListenableFuture<String> result = null;
        try {
            int a = 1/0;
            result = AsyncResult.forValue("success");
        } catch (Exception e) {
            result = AsyncResult.forExecutionException(e);
        }

        return result;
    }

}

package cn.caber.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    @GetMapping("/15s")
    public String set1(){
        try {
            Thread.sleep(15*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("15s 请求完成");
        return "success";
    }

    @GetMapping("/30s")
    public String set2(){
        try {
            Thread.sleep(30*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("30s 请求完成");
        return "success";
    }
}

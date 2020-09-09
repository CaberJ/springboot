package cn.caber.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@RestController
public class ThreadController {

    private static  final ThreadLocal<String> threadLocal = new ThreadLocal<String>();

    @GetMapping("/set")
    public String set(String str){
        String name = Thread.currentThread().getName();
        threadLocal.set(str);
        System.out.println(str+"放进去了");
        String s = threadLocal.get();
        String s1 = threadLocal.get();
        System.out.println("线程名:"+name);
        System.out.println("第一次："+s);
        System.out.println("第二次"+s1);
        return s;
    }

    @GetMapping("/set1")
    public String set1(String str){

        Map<String, String> strMap = UploadController.map.get();
        if(Objects.isNull(strMap)){
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(str,str+Thread.currentThread().getName());
            UploadController.map.set(hashMap);
        }else {
            strMap.put(str,str+Thread.currentThread().getName());
        }
        System.out.println(str+"放进去别的threadLocal了");
        String s = threadLocal.get();
        return s;
    }

    @GetMapping("/get")
    public String get(){
        String s = threadLocal.get();
        return  s;
    }

    @GetMapping("/get1")
    public String get1(){
        Map<String, String> stringStringMap = UploadController.map.get();
        if(Objects.nonNull(stringStringMap)){
            Set<Map.Entry<String, String>> entries = stringStringMap.entrySet();
            for (Map.Entry<String, String> entry : entries) {
                System.out.println(entry.getKey()+"--"+entry.getValue());
            }
        }
        return  "success";
    }

    @GetMapping("/remove")
    public String remove(){
        threadLocal.remove();
        return "remove success";
    }

    @GetMapping("/remove1")
    public String remove1(){
        UploadController.map.remove();
        return "remove1 success";
    }
}

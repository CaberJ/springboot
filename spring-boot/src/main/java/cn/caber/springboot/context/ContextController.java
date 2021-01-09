package cn.caber.springboot.context;

import cn.caber.springboot.context.ConText;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/context")
public class ContextController {

    @GetMapping("/set")
    public String set(String str){
        String name = Thread.currentThread().getName();
        Map<String, String> map = ConText.getMap();
        map.put(str,name);
        System.out.println("str"+str+"线程名:"+name);
        return str;
    }



    @GetMapping("/get")
    public String get(String str){
        Map<String, String> map = ConText.getMap();
        String s = map.get(str);
        System.out.println("线程名："+s);
        return  s;
    }

    @GetMapping("/remove")
    public String remove(String str){
        Map<String, String> map = ConText.getMap();
        String remove = map.remove(str);
        System.out.println("已移除："+remove);
        return  remove;
    }


}

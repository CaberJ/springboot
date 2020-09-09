package cn.caber.springboot.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpTestController {

    @PostMapping("/httpPost")
    public String httpPost(@RequestBody String name){
//        JSONObject jsonObject = JSONObject.parseObject("{\"tag_cn\":\"姓名\",\"value\":\"" + name + "\"}");
        return "{\"tag_cn\":\"姓名\",\"value\":\"" + name + "\"}";
    }
}

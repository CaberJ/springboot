package cn.caber.springbootstudy.restCall.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: zhaikaibo
 * @Date: 2019/5/30 10:23
 */

@Service
public class CallByRest implements ICallByRest {

    @Override
    public String doIt() {
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, String> paramsMap = new LinkedMultiValueMap<String, String>();
        paramsMap.add("name","caber");
        paramsMap.add("age","12");

        Map<String, String> map = new HashMap<String, String>();
        map.put("name","cabera");
        map.put("age","12a");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","cabera");
        jsonObject.put("age","12a");
//        String s = restTemplate.postForObject("localhost:8083/do2", jsonObject, String.class);


        String s = restTemplate.postForObject("localhost:8083/do1?name=libai&age=152", null, String.class);
        return s;
    }
}

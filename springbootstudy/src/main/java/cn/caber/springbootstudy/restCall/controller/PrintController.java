package cn.caber.springbootstudy.restCall.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.*;

/**
 * @Description:
 * @Author: zhaikaibo
 * @Date: 2019/5/29 16:37
 */
@RestController
@RequestMapping("/")
public class PrintController {



    @RequestMapping(value = "/do1",method = RequestMethod.POST)
    public String print(@RequestParam("name")String name,@RequestParam("age")String age){
        return name+age+1;
    }

    @RequestMapping(value = "/do2",method = RequestMethod.POST)
    public String print1(@RequestBody JSONObject a){
        String name = (String) a.get("name");
        String age = (String) a.get("age");
        return name+age+2;
    }
}

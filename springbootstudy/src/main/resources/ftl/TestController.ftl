package cn.caber.springbootstudy.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
* @Description:
* @Author: zhaikaibo
* @Date: 2019/6/25 17:08
*/
@RestController
public class ${name}Controller {

    @RequestMapping("/aaa")
    public String aa() {
        return "aaa";
    }
}

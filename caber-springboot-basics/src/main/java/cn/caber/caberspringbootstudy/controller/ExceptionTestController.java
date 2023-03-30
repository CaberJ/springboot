package cn.caber.caberspringbootstudy.controller;

import cn.caber.caberspringbootstudy.exception.MyChildException;
import cn.caber.caberspringbootstudy.exception.MyException;
import cn.caber.caberspringbootstudy.common.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exc")
public class ExceptionTestController {

    @RequestMapping("/test1")
    public Result test1(){
        throw new MyException(1,"异常测试");
    }


    @RequestMapping("/test2")
    public Result test2() {
        throw new MyChildException(1,"异常测试");
    }


}

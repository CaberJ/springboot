package cn.caber.springbootstudy.restCall.controller;



import cn.caber.springbootstudy.restCall.service.ICallByRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: zhaikaibo
 * @Date: 2019/5/30 10:26
 */
@RestController
@RequestMapping("/")
public class RestContoller {

    @Autowired
    private ICallByRest callByRest;


    @RequestMapping(value = "/doRest")
    public String print(){
        String s = callByRest.doIt();
        return s;
    }


}

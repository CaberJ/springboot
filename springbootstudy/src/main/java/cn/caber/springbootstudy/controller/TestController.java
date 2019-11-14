package cn.caber.springbootstudy.controller;

import cn.caber.springbootstudy.bean.ConditionBean;
import cn.caber.springbootstudy.jdkspi.Publish;
import cn.caber.springbootstudy.springspi.MyClass;
import cn.caber.springbootstudy.springspi.MyInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @Description:
 * @Author: zhaikaibo
 * @Date: 2019/6/25 17:08
 */
@RestController
public class TestController {

    private ServiceLoader<Publish> publish = ServiceLoader.load(Publish.class);


    @Autowired
    private MyInterface myInterface;

    @Autowired
    private MyClass myClass;

    @Autowired
    private ConditionBean conditionBean;

    //condition测试
    @RequestMapping("/condition")
    public String condition() {
        String status = conditionBean.getStatus();
        return status;
    }


    //jdkSpi测试
    @RequestMapping("/jdkSpi")
    public String jdkSpi() {
        Iterator<Publish> iterator = publish.iterator();
        Publish next = null;
        String pub = "";
        while (iterator.hasNext()) {
            next = iterator.next();
            pub = next.pub();
        }
        return pub;
    }

    //springSpi测试
    @RequestMapping("/springSpi")
    public String springSpi() {
        return myInterface.sayHello();
    }

    //springSpi测试2
    @RequestMapping("/springSpi2")
    public String springSpi2() {
        return myClass.sayHi();
    }

}

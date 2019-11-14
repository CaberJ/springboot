package cn.caber.springbootstudy.springspi.impl;

import cn.caber.springbootstudy.bean.People;
import cn.caber.springbootstudy.springspi.MyInterface;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description:
 * @Author: zhaikaibo
 * @Date: 2019/6/29 17:40
 */
public class MyClass2 implements MyInterface {

    @Autowired
    private People people;

    @Override
    public String sayHello() {
        return people.getName()+2;
    }
}

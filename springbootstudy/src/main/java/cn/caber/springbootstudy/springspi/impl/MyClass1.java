package cn.caber.springbootstudy.springspi.impl;

import cn.caber.springbootstudy.springspi.MyInterface;

/**
 * @Description:
 * @Author: zhaikaibo
 * @Date: 2019/6/29 17:39
 */
public class MyClass1 implements MyInterface {

    @Override
    public String sayHello() {
        return "hello1";
    }
}

package cn.caber.springbootstudy.springspi.impl;

import cn.caber.springbootstudy.springspi.MyInterface;

/**
 * @Description:
 * @Author: zhaikaibo
 * @Date: 2019/6/29 17:40
 */
public class MyClass2 implements MyInterface {
    @Override
    public String sayHello() {
        return "hello2";
    }
}

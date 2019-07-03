package cn.caber.springbootstudy.jdkspi.impl;

import cn.caber.springbootstudy.jdkspi.Publish;

/**
 * @Description:
 * @Author: zhaikaibo
 * @Date: 2019/6/26 11:11
 */


public class Hepublish implements Publish {
    @Override
    public String pub() {
        System.out.println("Hepublish执行");
        return "Hepublish";
    }
}

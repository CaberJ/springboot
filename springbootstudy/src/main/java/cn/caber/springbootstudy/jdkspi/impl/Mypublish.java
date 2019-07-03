package cn.caber.springbootstudy.jdkspi.impl;

import cn.caber.springbootstudy.jdkspi.Publish;

/**
 * @Description:
 * @Author: zhaikaibo
 * @Date: 2019/6/26 11:06
 */
public class Mypublish implements Publish {

    public String pub(){
        System.out.println("Mypublish执行");
        return "Mypublish";
    }
}

package cn.caber.springbootstudy.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: zhaikaibo
 * BeanPostProcessor   实现这个接口的bean，在容器中的每个bean初始化前后都会执行对应的
 * postProcessBeforeInitialization和postProcessAfterInitialization 方法，如果有多个，则每个都走
 * @Date: 2019/5/7 17:32
 */
//@Component
public class PostProcessor1 implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("副本-每个bean初始化前执行，beforeInitialization "+o+" beanName="+s);
        return o;
    }

    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("副本-每个bean初始化后执行afterInitialization "+o+" beanName="+s);
        return o;
    }
}

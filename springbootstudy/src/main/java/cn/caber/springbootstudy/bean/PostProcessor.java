package cn.caber.springbootstudy.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: zhaikaibo
 * @Date: 2019/5/7 17:32
 */
//@Component
public class PostProcessor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("每个bean初始化前执行，beforeInitialization "+o+" beanName="+s);
        return o;
    }

    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        if("initHandle".equals(s)){
            System.out.println("initHandle bean 初始化后执行。。。");
        }
        System.out.println("每个bean初始化后执行afterInitialization "+o+" beanName="+s);
        return o;
    }
}

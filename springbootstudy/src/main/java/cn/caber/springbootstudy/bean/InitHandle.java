package cn.caber.springbootstudy.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Description:
 * @Author: zhaikaibo
 * InitializingBean  实现这个接口的Bean在他自己初试化时都会执行afterPropertiesSet()
 * @Date: 2019/5/7 17:15
 */
//@Component
public class InitHandle implements InitializingBean/*, ApplicationContextAware*/ {
//    ApplicationContext applicationContext;

    public void afterPropertiesSet() throws Exception {
        System.out.println("InitHandle 的 afterPropertiesSet执行了");
    }

    public void init(){

        System.out.println("InitHandle的 init 执行了");
    }

    public void destroy(){
        System.out.println(" InitHandle的 destroy 执行了");
    }

    public InitHandle() {
        System.out.println("InitHandle的 构造方法");
    }

    /*@Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }*/
}

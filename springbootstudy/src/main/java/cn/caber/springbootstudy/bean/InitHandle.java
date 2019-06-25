package cn.caber.springbootstudy.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;

/**
 * @Description:
 * @Author: zhaikaibo
 * @Date: 2019/5/7 17:15
 */
public class InitHandle implements InitializingBean/*, ApplicationContextAware*/ {
//    ApplicationContext applicationContext;

    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet执行了");
    }

    public void init(){

        System.out.println("init 执行了");
    }

    public void destroy(){
        System.out.println("destroy 执行了");
    }

    public InitHandle() {
        System.out.println("构造方法");
    }

    /*@Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }*/
}

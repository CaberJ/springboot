package cn.caber.springbootstudy.bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: zhaikaibo
 * @Date: 2019/5/7 17:15
 */
//@Component
public class InitHandle1 implements InitializingBean/*, ApplicationContextAware*/ {
//    ApplicationContext applicationContext;

    public void afterPropertiesSet() throws Exception {
        System.out.println("InitHandle1 的 afterPropertiesSet执行了");
    }

    public void init(){

        System.out.println("InitHandle1 的 init 执行了");
    }

    public void destroy(){
        System.out.println(" InitHandle1 的 destroy 执行了");
    }

    public InitHandle1() {
        System.out.println("InitHandle1 的 构造方法");
    }

    /*@Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }*/
}

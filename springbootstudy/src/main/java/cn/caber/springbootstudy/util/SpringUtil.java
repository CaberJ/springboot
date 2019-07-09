package cn.caber.springbootstudy.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.env.Environment;

/**
 * @Description:
 * @Author: zhaikaibo
 * @Date: 2019/7/9 20:04
 */
public class SpringUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if(SpringUtil.applicationContext==null){
            SpringUtil.applicationContext=applicationContext;
        }
    }

    private static ApplicationContext getApplicationContext(){
        return applicationContext;
    }

    //获取配置信息赋值给静态变量
    private static Environment getEnvironment(){
        return getApplicationContext().getEnvironment();
    }
}

package cn.caber.springbootstudy.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: zhaikaibo
 * @Date: 2019/7/9 20:04
 */

@Component
public class SpringUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if(SpringUtil.applicationContext==null){
            SpringUtil.applicationContext=applicationContext;
        }
    }

    /**
     * 获取ApplicationContext
     * @return
     */
    public static ApplicationContext getApplicationContext(){
        return applicationContext;
    }


    //获取配置信息赋值给静态变量
    public static Environment getEnvironment(){
        return getApplicationContext().getEnvironment();
    }

    public static Object getBeanByClass(Class<?> clazz) {
        return getApplicationContext().getBean(clazz.getSimpleName());
    }

    public static Object getBeanByName(String name) {
        return getApplicationContext().getBean(name);
    }





}

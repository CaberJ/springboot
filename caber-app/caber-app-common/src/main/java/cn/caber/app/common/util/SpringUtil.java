package cn.caber.app.common.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class SpringUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public static Object getBean(String beanName) {
        if (StringUtils.isEmpty(beanName)) {
            return null;
        }
        return applicationContext.getBean(beanName);
    }

    public static Object getBean(Class clazz) {
        return applicationContext.getBean(clazz);
    }

}

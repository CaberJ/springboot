package cn.caber.springbootstudy.listener;

import cn.caber.springbootstudy.env.TestConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class MySpringApplicationRunListener implements SpringApplicationRunListener {

    public MySpringApplicationRunListener(SpringApplication application, String[] args){
        
    }

    /**
     * IOC容器创建之前调用
     */
    @Override
    public void starting() {
        System.out.println("SpringApplicationRunListener..starting ..");
    }

    /**
     * environment 准备好后调用
     * @param environment
     */
    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        System.out.println("SpringApplicationRunListener .. environment..");
    }

    /**
     * context 创建后调用
     * @param context
     */
    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        System.out.println("SpringApplicationRunListener .. contextPrepared..");
    }

    /**
     * context 加载时调用
     * @param context
     */
    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        System.out.println("SpringApplicationRunListener .. contextLoaded..");
    }

    @Override
    public void started(ConfigurableApplicationContext context) {
        System.out.println("SpringApplicationRunListener .. started..");
    }

    @Override
    public void running(ConfigurableApplicationContext context) {
        System.out.println("SpringApplicationRunListener .. running..");
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {

    }
}

package cn.caber.springbootstudy.load;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @Description:
 * @Author: zhaikaibo
 * @Date: 2019/9/27 10:11
 */
public class ApplicationListenerTest implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        System.out.println("容器初始化完成");
    }
}

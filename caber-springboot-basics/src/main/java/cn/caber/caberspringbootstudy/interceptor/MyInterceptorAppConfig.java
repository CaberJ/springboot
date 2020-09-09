package cn.caber.caberspringbootstudy.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 将拦截器注册到拦截器注册表,
 */

@Configuration
public class MyInterceptorAppConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private MyInterceptor myInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(myInterceptor);
        interceptorRegistration.excludePathPatterns("/test");
        interceptorRegistration.addPathPatterns("/**");
        //如果有多个拦截器
        //InterceptorRegistration interceptorRegistration2  = registry.addInterceptor(new MyInterceptor2());
        super.addInterceptors(registry);
    }


}

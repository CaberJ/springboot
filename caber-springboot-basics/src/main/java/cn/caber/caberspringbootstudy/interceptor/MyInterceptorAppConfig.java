package cn.caber.caberspringbootstudy.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 将拦截器注册到拦截器注册表,
 *  WebMvcConfigurer 功能如下
 *  addInterceptors：拦截器
 *  addViewControllers：页面跳转
 *  addResourceHandlers：静态资源
 *  configureDefaultServletHandling：默认静态资源处理器
 *  configureViewResolvers：视图解析器
 *  configureContentNegotiation：配置内容裁决的一些参数
 *  addCorsMappings：跨域
 *  configureMessageConverters：信息转换器
 */

@Configuration
public class MyInterceptorAppConfig implements WebMvcConfigurer {

    @Autowired
    private MyInterceptor myInterceptor;

    /**
     * 注册拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(myInterceptor);
        interceptorRegistration.excludePathPatterns("/test");
        interceptorRegistration.addPathPatterns("/**");
        //如果有多个拦截器
        //InterceptorRegistration interceptorRegistration2  = registry.addInterceptor(new MyInterceptor2());

    }

    /**
     * 允许跨域
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
    /*    registry.addMapping("/**").allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE").allowedOrigins("*")
                .allowedHeaders("*").maxAge(36000).allowCredentials(true);*/
        registry.addMapping("/**").allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE").allowedOriginPatterns("*")
                .allowedHeaders("*").maxAge(36000).allowCredentials(true);
    }


}

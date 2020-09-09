package cn.caber.caberspringbootstudy.filter.configuretion;

import cn.caber.caberspringbootstudy.filter.MyFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * filter的另一种配置方法，采用配置类的方式，
 * 因为我已经采用了注解的方式来配置filter所以此处暂时注释掉
 */
//@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean testFilterRegistration() {

        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new MyFilter());
        registration.addUrlPatterns("/*");
        registration.addInitParameter("paramName", "paramValue");
        registration.setName("MyFilter");
        registration.setOrder(1);
        return registration;
    }
}

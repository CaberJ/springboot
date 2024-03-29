package cn.caber.springbootstudy.config;

import cn.caber.springbootstudy.bean.InitHandle;
import cn.caber.springbootstudy.util.SpringUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean(initMethod = "init",destroyMethod = "destroy")
    public InitHandle getInitHandle(){
        return  new InitHandle();
    }

    @Bean
    public SpringUtil springUtil(){
        return new SpringUtil();
    }
}

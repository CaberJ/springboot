package cn.caber.springbootstudy.config;

import cn.caber.springbootstudy.bean.InitHandle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean(initMethod = "init",destroyMethod = "destroy")
    public InitHandle getInitHandle(){
        return  new InitHandle();
    }
}

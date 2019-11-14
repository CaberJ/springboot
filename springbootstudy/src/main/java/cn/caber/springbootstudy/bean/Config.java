package cn.caber.springbootstudy.bean;

import cn.caber.springbootstudy.bean.People;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author: zhaikaibo
 * @Date: 2019/11/14 17:07
 */

@Configuration
public class Config {

    @Bean
    public People getPeople(){
        return new People("caber",12);
    }
}

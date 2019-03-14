package cn.caber.caberspringbootstudy.configuretion;

import cn.caber.caberspringbootstudy.domain.Group;
import cn.caber.caberspringbootstudy.domain.People;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PeopleConfig {

    @Bean
    @ConfigurationProperties(prefix = "people")
    public People getPeople(){
        return new People();
    }

    /*@Bean
    @ConfigurationProperties(prefix = "group")
    public People getGroup(){
        return new Group();
    }*/




}

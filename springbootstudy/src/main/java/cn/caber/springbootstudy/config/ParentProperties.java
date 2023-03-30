package cn.caber.springbootstudy.config;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Data
@ToString
@Configuration
@ConfigurationProperties("cn.caber.demo1.aa")
public class ParentProperties implements EnvironmentAware {

    private Environment environment;
    private String aname;
    private Integer aage;
    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }



}

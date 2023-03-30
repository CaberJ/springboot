package cn.caber.springbootstudy.config;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@ToString
@Configuration
@ConfigurationProperties("demo1.aa")
public class AProperties extends ParentProperties{
    private String aname;
    private Integer aage;
}

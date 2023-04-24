package cn.caber.caberspringbootstudy.component;

import cn.caber.caberspringbootstudy.annotation.ClassNamePrint;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "student")
//Spring Boot 默认不支持@PropertySource读取yaml 文件, 如果有需求，需要自定义实现factory并配置factory属性
@PropertySource(value = "classpath:/student.properties")
@ClassNamePrint("student")
@Data
public class Student {
    private int id;
    private String name;
    private int age;

    @NestedConfigurationProperty
    private Apple apple;

}

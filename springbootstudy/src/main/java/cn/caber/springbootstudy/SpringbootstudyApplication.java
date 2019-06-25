package cn.caber.springbootstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.PropertySource;

@SpringBootApplication
public class SpringbootstudyApplication {


    public static void main(String[] args) {

        ConfigurableApplicationContext run = SpringApplication.run(SpringbootstudyApplication.class, args);
        String aa = run.getEnvironment().getProperty("aa");
        PropertySource<?> map = run.getEnvironment().getPropertySources().get("map");
        System.out.println("map="+map);
        System.out.println("===="+aa);

    }
}

package cn.caber.springboot;

import cn.caber.springboot.circularDependencies.A;
import cn.caber.springboot.circularDependencies.B;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
//@EnableScheduling
@EnableAsync
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);
        B b = (B)run.getBean("b");
        A a = (A)run.getBean("a");
        System.out.println(a.getName());
        System.out.println(a.getB().getName());

    }

}

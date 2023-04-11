package cn.caber.app.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@MapperScan(basePackages = {"cn.caber.app.server.*.mapper"})
public class CaberAppServerApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(CaberAppServerApplication.class, args);
        System.out.println("CaberAppServer started successfully!");
    }

}

package cn.caber.app.server;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan(basePackages = {"cn.caber.app.server.*.mapper"}, sqlSessionFactoryRef = "sqlSessionFactory")
public class CaberAppServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CaberAppServerApplication.class, args);
        System.out.println("Application started successfully!");
    }

}

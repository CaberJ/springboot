package cn.caber.app.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CaberAppWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(CaberAppWebApplication.class, args);
        System.out.println("Application started successfully!");
    }
}

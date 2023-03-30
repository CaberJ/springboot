package cn.caber.springbootstudy.runner;

import cn.caber.springbootstudy.env.TestConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationRunner implements ApplicationRunner {

    @Autowired
    private TestConfig testConfig;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("ApplicationRunner ...");
        System.out.println(testConfig.toString());
    }
}

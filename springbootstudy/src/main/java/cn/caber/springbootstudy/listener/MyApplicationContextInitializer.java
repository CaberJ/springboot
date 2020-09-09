package cn.caber.springbootstudy.listener;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;

import java.util.HashMap;
import java.util.Map;

public class MyApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        System.out.println("ApplicationContextInitializer .. initialize..");


        Map<String, Object> map = new HashMap<>();
        map.put("aa", "bb");
        PropertySource mapPropertySource = new MapPropertySource("map", map);
        configurableApplicationContext.getEnvironment().getPropertySources().addFirst(mapPropertySource);

        System.out.println("直接获取" + configurableApplicationContext.getEnvironment().getProperty("aa"));

        
    }
}

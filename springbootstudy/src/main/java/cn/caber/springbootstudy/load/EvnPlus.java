package cn.caber.springbootstudy.load;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: zhaikaibo
 * @Date: 2019/6/24 18:08
 */
@Component
public class EvnPlus implements ApplicationContextInitializer<ConfigurableApplicationContext>{

    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        Map<String, Object> map = new HashMap<>();
        map.put("aa", "bb");
        PropertySource mapPropertySource = new MapPropertySource("map", map);
        configurableApplicationContext.getEnvironment().getPropertySources().addFirst(mapPropertySource);

        System.out.println("直接获取"+configurableApplicationContext.getEnvironment().getProperty("aa"));

    }
}

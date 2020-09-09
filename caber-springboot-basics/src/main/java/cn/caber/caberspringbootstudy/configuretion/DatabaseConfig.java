package cn.caber.caberspringbootstudy.configuretion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan
public class DatabaseConfig {

   /* @Bean
    public RedisConnectionFactory redisCF(){
        //如果什么参数都不设置，默认连接本地6379端口
        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setPort(6379);
        factory.setHostName("localhost");
        return factory;
    }*/

}

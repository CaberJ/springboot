package cn.caber.caberspringbootstudy.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloController {

    @Autowired
    private JedisConnectionFactory factory;

    @RequestMapping("/a")
    public String printPeople(){
        RedisConnection connection = factory.getConnection();
        connection.setCommands().sAdd("name".getBytes(),"lisi".getBytes());
        byte[] bytes = connection.get("name".getBytes());
        String s = new String(bytes);
        return s;

    }



}

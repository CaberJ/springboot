package cn.caber.caberspringbootstudy.mq.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;


@Configuration
public class RabbitmqConfig {


    @Value("${spring.rabbitmq.host}")
    private String host;

    @Value("${spring.rabbitmq.port}")
    private int port;

    @Value("${spring.rabbitmq.username}")
    private String username;

    @Value("${spring.rabbitmq.password}")
    private String password;

    @Value(value = "${spring.rabbitmq.queue.name}")
    private String queueName;

    @Value(value = "${spring.rabbitmq.virtual-host}")
    private String vhost;

    /**
     * 创建一个消息队列
     */
    @Bean
    public Queue testDirectQueue() {
        Map<String, Object> map = new HashMap<String, Object>();
      /*  map.put("x-dead-letter-exchange", "dead_letter_exchange");//设置死信交换机
        map.put("x-dead-letter-routing-key", "mail_queue_fail");//设置死信routingKey*/
        return new Queue("caberDirectQueue", true, false, false, map);
    }

    @Bean
    public DirectExchange testDirectExchange() {
        return new DirectExchange("caberDirectExchange", true, false);
    }

    @Bean
    public Binding testDirectBinding() {
        return BindingBuilder.bind(testDirectQueue()).to(testDirectExchange()).with("11111");
    }

    /**
     * fanout类型的Exchange不管Routing key是什么，它都会将接收到的消息分发给所有与自己绑定了的Queue上。
     * @return
     */
    @Bean
    public Queue testFanoutQueue1() {
        Map<String, Object> map = new HashMap<String, Object>();
        return new Queue("caberFanoutQueue1", true, false, false, map);
    }

    @Bean
    public Queue testFanoutQueue2() {
        Map<String, Object> map = new HashMap<String, Object>();
        return new Queue("caberFanoutQueue2", true, false, false, map);
    }

    @Bean
    public FanoutExchange testFanoutExchange() {
        return new FanoutExchange("caberFanoutExchange", true, false);
    }

    @Bean
    public Binding testFanoutBinding1() {
        return BindingBuilder.bind(testFanoutQueue1()).to(testFanoutExchange());
    }
    @Bean
    public Binding testFanoutBinding2() {
        return BindingBuilder.bind(testFanoutQueue2()).to(testFanoutExchange());
    }

    /**
     * topic的意思是主题，topic类型的Exchange会根据通配符对Routing key进行匹配，只要Routing key满足某个通配符的条件，就会被路由到对应的Queue上。通配符的匹配规则如下：
     * ● Routing key必须是一串字符串，每个单词用“.”分隔；
     * ● 符号“#”表示匹配一个或多个单词；
     * ● 符号“*”表示匹配一个单词。
     * 例如：“*.123” 能够匹配到 “abc.123”，但匹配不到 “abc.def.123”；“#.123” 既能够匹配到 “abc.123”，也能匹配到 “abc.def.123”。
     * @return
     */
    @Bean
    public Queue testTopicQueue1() {
        Map<String, Object> map = new HashMap<String, Object>();
        return new Queue("caberTopicQueue1", true, false, false, map);
    }

    @Bean
    public Queue testTopicQueue2() {
        Map<String, Object> map = new HashMap<String, Object>();
        return new Queue("caberTopicQueue2", true, false, false, map);
    }

    @Bean
    public Queue testTopicQueue3() {
        Map<String, Object> map = new HashMap<String, Object>();
        return new Queue("caberTopicQueue3", true, false, false, map);
    }


    @Bean
    public TopicExchange testTopicExchange() {
        return new TopicExchange("caberTopicExchange", true, false);
    }

    @Bean
    public Binding testTopicBinding1() {
        return BindingBuilder.bind(testTopicQueue1()).to(testTopicExchange()).with("a.*");
    }
    @Bean
    public Binding testTopicBinding2() {
        return BindingBuilder.bind(testTopicQueue2()).to(testTopicExchange()).with("*.b");
    }
    @Bean
    public Binding testTopicBinding3() {
        return BindingBuilder.bind(testTopicQueue3()).to(testTopicExchange()).with("#.b");
    }


    @Bean
    RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory, Jackson2JsonMessageConverter converter) {
        RabbitTemplate template = new RabbitTemplate();
        template.setConnectionFactory(connectionFactory);
        template.setMessageConverter(converter);
        return template;
    }

    /**
     * 使用 Jackson 转化器原因：
     * 1. 使数据在远程以json的形式保存
     * 2. 使不同的客户端接受相同类型的数据时，使数据能正常转换
     */
    @Bean
    Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean(name = "connectionFactory")
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(host, port);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        connectionFactory.setVirtualHost(vhost);
        return connectionFactory;
    }


}

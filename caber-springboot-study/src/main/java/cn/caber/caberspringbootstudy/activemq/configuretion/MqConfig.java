package cn.caber.caberspringbootstudy.activemq.configuretion;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;


@Configuration
@EnableJms//触发发现使用@JmsListener注解的方法，创建消息监听器容器。
public class MqConfig {

    @Value("${spring.activemq.broker-url}")
    private String ActiveMQ_URL;

    //修改模式时，注意修改配置文件中的 spring.jms.pub-sub-domain

    //创建队列目的地，queue模式
    @Bean
    public Queue queue() {
        //对列名
        return new ActiveMQQueue("sample.queue");
    }

    //创建队列目的地，topic模式
    @Bean
    public Topic topic() {
        //对列名
        return new ActiveMQTopic("sample.topic");
    }

    //同一个项目中同时使用queue和topic两种模式，可采用如下配置；也可只采用其中一种，
    //如果同时采用两种模式，且消费者采用@JmsListener注解方式时，需要在@JmsListener中注明使用的是哪一个JmsListenerContainerFactory
    //

    // topic模式的ListenerContainer
    @Bean
    public JmsListenerContainerFactory<?> jmsListenerContainerTopic(ConnectionFactory activeMQConnectionFactory) {
        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
        bean.setPubSubDomain(true);
        bean.setConnectionFactory(activeMQConnectionFactory);
        return bean;
    }
    // queue模式的ListenerContainer
    @Bean
    public JmsListenerContainerFactory<?> jmsListenerContainerQueue(ConnectionFactory activeMQConnectionFactory) {
        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
        bean.setPubSubDomain(false);
        bean.setConnectionFactory(activeMQConnectionFactory);
        return bean;
    }
}

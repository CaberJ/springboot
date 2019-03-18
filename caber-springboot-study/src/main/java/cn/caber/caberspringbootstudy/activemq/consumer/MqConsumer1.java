package cn.caber.caberspringbootstudy.activemq.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MqConsumer1 {

    @JmsListener(destination = "sample.queue",containerFactory = "jmsListenerContainerQueue") // 监听指定消息主题
    //使用此注解的方法，返回值类型只能是void  否则会报错，且消息自动被消费
    public void receiveQueue(String message) {
        System.out.println("queue: "+message);
    }

    @JmsListener(destination = "sample.topic",containerFactory = "jmsListenerContainerTopic") // 监听指定消息主题
    public void receiveTopic(String message) {
        System.out.println("topic: "+message);
    }
}

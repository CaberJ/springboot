package cn.caber.caberspringbootstudy.mq.rabbitmq;

import cn.caber.caberspringbootstudy.mq.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitmqConsumer {
    @RabbitHandler
    @RabbitListener(queues = "caberDirectQueue")
    public void handleDirect(User user) {
        System.out.println("caberDirectQueue消费者收到消息  : " + user.toString());
    }

    @RabbitHandler
    @RabbitListener(queues = "caberFanoutQueue1")
    public void handleFanout1(User user) {
        System.out.println("caberFanoutQueue1消费者收到消息  : " + user.toString());
    }

    @RabbitHandler
    @RabbitListener(queues = "caberFanoutQueue2")
    public void handleFanout2(User user) {
        System.out.println("caberFanoutQueue2消费者收到消息  : " + user.toString());
    }

    @RabbitHandler
    @RabbitListener(queues = "caberTopicQueue1")
    public void handleTopic1(User user) {
        System.out.println("caberTopicQueue1消费者收到消息  : " + user.toString());
    }
    @RabbitHandler
    @RabbitListener(queues = "caberTopicQueue2")
    public void handleTopic2(User user) {
        System.out.println("caberTopicQueue2消费者收到消息  : " + user.toString());
    }
    @RabbitHandler
    @RabbitListener(queues = "caberTopicQueue3")
    public void handleTopic3(User user) {
        System.out.println("caberTopicQueue3消费者收到消息  : " + user.toString());
    }
}


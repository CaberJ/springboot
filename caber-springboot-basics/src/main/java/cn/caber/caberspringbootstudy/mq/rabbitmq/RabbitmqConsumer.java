package cn.caber.caberspringbootstudy.mq.rabbitmq;

import cn.caber.caberspringbootstudy.mq.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitmqConsumer {

    /**
     * @RabbitListener 和 @RabbitHandler 搭配使用
     * @RabbitListener 可以标注在类上面，需配合 @RabbitHandler 注解一起使用
     * @RabbitListener 标注在类上面表示当有收到消息的时候，就交给 @RabbitHandler 的方法处理，具体使用哪个方法处理，根据 MessageConverter 转换后的参数类型
     * ————————————————
     */



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


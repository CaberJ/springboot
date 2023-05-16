package cn.caber.caberspringbootstudy.mq.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RabbitmqProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public boolean send(String routingKey, String exchange, Object user) {
        MessagePostProcessor message = new MessagePostProcessor() {
            /**
             * 设置消息头中的消息
             */
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                message.getMessageProperties().setHeader("headMsg", "caber");
                // User类自动转化位字符串类型
                message.getMessageProperties().setHeader("headContent", user);
                return message;
            }
        };
        log.info("send: " + routingKey + " : " + user);
//        rabbitTemplate.convertAndSend(queue, user, message);
        rabbitTemplate.convertAndSend(exchange, routingKey, user, message);
        return true;
    }

}

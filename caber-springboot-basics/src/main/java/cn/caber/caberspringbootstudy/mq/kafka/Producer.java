package cn.caber.caberspringbootstudy.mq.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

@Component
public class Producer {


    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void send(String topic){
        String message = "hello-123456789";
        ListenableFuture key = kafkaTemplate.send(topic, message);
    }

}

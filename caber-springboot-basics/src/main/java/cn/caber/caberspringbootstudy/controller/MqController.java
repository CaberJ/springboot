package cn.caber.caberspringbootstudy.controller;

import cn.caber.caberspringbootstudy.mq.User;
import cn.caber.caberspringbootstudy.mq.activemq.consumer.MqConsumer;
import cn.caber.caberspringbootstudy.mq.activemq.producter.MqProducter;
import cn.caber.caberspringbootstudy.mq.rabbitmq.RabbitmqProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MqController {

    @Autowired
    private MqProducter mqProducter;

    @Autowired
    private RabbitmqProducer rabbitmqProducer;

    @Autowired
    private MqConsumer mqConsumer;


    @RequestMapping("/sendQueue")
    public void sendQueue(String msg) {
        mqProducter.sendQueue(msg);
    }

    @RequestMapping("/sendTopic")
    public void sendTopic(String msg) {
        mqProducter.sendTopic(msg);
    }

    /* @RequestMapping("/receive")
     public String receive(String dis) {
         String receive = mqConsumer.receive(dis);
         return receive;
     }*/

    @PostMapping("/send/{queue}")
    public void send(@PathVariable("queue") String queue, @RequestBody User user) {
        rabbitmqProducer.send(queue, user);
    }




}

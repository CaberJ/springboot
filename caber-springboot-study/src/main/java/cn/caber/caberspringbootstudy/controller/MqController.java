package cn.caber.caberspringbootstudy.controller;

import cn.caber.caberspringbootstudy.activemq.consumer.MqConsumer;
import cn.caber.caberspringbootstudy.activemq.producter.MqProducter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mq")
public class MqController {

    @Autowired
    private MqProducter mqProducter;

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
}

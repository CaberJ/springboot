package cn.caber.caberspringbootstudy.activemq.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

@Component
public class MqConsumer {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;



/*    public String receive(String dis) {
        Message<?> receive = jmsMessagingTemplate.receive(dis);
        MessageHeaders headers = receive.getHeaders();
        Object payload = receive.getPayload();
        return "headers: " + headers.toString() + " payload: " + payload.toString();

        *//*
        结果为：
        headers: {
            jms_redelivered=false,
            jms_deliveryMode=2,
            jms_destination=queue://sample.queue,
            jms_priority=4, id=3dc2cf7a-ab07-d9ec-7108-a39d5dd96f1b,
            jms_timestamp=1552894243021,
            jms_expiration=0,
            jms_messageId=ID:DESKTOP-D3859II-50130-1552894242791-1:1:1:1:1,
            timestamp=1552894257814
            }
         payload: hehehesd
         *//*
    }*/
}

package cn.caber.caberspringbootstudy.controller;


import cn.caber.caberspringbootstudy.kafka.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    @Autowired
    private Producer producer;

    private String topic = "Hello-Topic-1";

    @RequestMapping("/send")
    private void send(){
        producer.send(topic);
    }
}

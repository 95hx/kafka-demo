package com.example.kafkademo.kafka;

/**
 * @author hx
 * @Title: Producer
 * @ProjectName micro-server-demo
 * @Description: TODO
 * @date 2018/8/2220:06
 */
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer {
    private final KafkaTemplate<Object, SampleMessage> kafkaTemplate;

    Producer(KafkaTemplate<Object, SampleMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(SampleMessage message) {
        this.kafkaTemplate.send(kafkaTemplate.getDefaultTopic(), message);
        System.out.println("Sent sample message [" + message + "]");
    }

}

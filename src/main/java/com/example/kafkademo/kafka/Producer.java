package com.example.kafkademo.kafka;

/**
 * @author hx
 * @Title: Producer
 * @ProjectName micro-server-demo
 * @Description: TODO
 * @date 2018/8/2220:06
 */
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer {
//    @Value("${spring.kafka.template.default-topic}")
//    private String topic;
    private final KafkaTemplate<Object, SampleMessage> kafkaTemplate;

    Producer(KafkaTemplate<Object, SampleMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(SampleMessage message) {
        this.kafkaTemplate.send("test", message);
        System.out.println("Sent sample message [" + message + "]");
    }

}

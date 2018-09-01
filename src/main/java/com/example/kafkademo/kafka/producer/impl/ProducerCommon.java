package com.example.kafkademo.kafka.producer.impl;

/**
 * @author hx
 * @Title: Producer
 * @ProjectName micro-server-demo
 * @Description: TODO
 * @date 2018/8/2220:06
 */
import com.example.kafkademo.kafka.producer.Producer;
import com.example.kafkademo.kafka.SampleMessage;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component(value = "producerCommon")
public class ProducerCommon implements Producer {

    private final KafkaTemplate<Object, SampleMessage> kafkaTemplate;

    ProducerCommon(KafkaTemplate<Object, SampleMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    @Override
    public void send(SampleMessage message) {
        System.out.println(kafkaTemplate.getDefaultTopic()+"-------------------------");
        this.kafkaTemplate.send(kafkaTemplate.getDefaultTopic(), message);
        System.out.println("Sent sample message [" + message + "]");
    }

}

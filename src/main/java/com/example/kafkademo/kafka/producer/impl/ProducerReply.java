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
import org.springframework.kafka.requestreply.ReplyingKafkaTemplate;
import org.springframework.stereotype.Component;


@Component(value = "producerReply")
public class ProducerReply implements Producer {

    private final ReplyingKafkaTemplate<Object, SampleMessage, String> replyingKafkaTemplate;

    ProducerReply(ReplyingKafkaTemplate<Object, SampleMessage, String> replyingKafkaTemplate) {
        this.replyingKafkaTemplate = replyingKafkaTemplate;
    }

    @Override
    public void send(SampleMessage message) {
        this.replyingKafkaTemplate.send(replyingKafkaTemplate.getDefaultTopic(), message);
        System.out.println("Sent replying sample message [" + message + "]");
    }


}

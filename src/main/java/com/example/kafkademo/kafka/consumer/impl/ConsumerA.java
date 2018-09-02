package com.example.kafkademo.kafka.consumer.impl;

/**
 * @author hx
 * @Title: ConsumerA
 * @ProjectName micro-server-demo
 * @Description: TODO
 * @date 2018/8/2220:07
 */

import com.example.kafkademo.kafka.consumer.Consumer;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class ConsumerA implements Consumer {

    @Override
    @SendTo
    @KafkaListener(topics = "__consumer_offsets")
    public void processMessage(Object message) {
        System.out.println("A Received offset message [" + message + "]");
    }


}

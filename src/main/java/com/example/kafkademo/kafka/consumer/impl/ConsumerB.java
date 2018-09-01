package com.example.kafkademo.kafka.consumer.impl;

/**
 * @author hx
 * @Title: ConsumerB
 * @ProjectName micro-server-demo
 * @Description: TODO
 * @date 2018/8/2220:07
 */

import com.example.kafkademo.kafka.consumer.Consumer;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerB implements Consumer {

    @Override
    @KafkaListener(topics = "test")
    public void processMessage(Object message) {
        System.out.println("B Received sample message [" + message + "]");
    }

}

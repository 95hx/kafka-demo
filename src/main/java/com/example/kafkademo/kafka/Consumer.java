package com.example.kafkademo.kafka;

/**
 * @author hx
 * @Title: Consumer
 * @ProjectName micro-server-demo
 * @Description: TODO
 * @date 2018/8/2220:07
 */

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    @KafkaListener(topics = "test")
    public void processMessage(SampleMessage message) {
        System.out.println("Received sample message [" + message + "]");
    }

}

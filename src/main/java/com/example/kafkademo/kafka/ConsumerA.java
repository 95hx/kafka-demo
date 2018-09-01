package com.example.kafkademo.kafka;

/**
 * @author hx
 * @Title: ConsumerA
 * @ProjectName micro-server-demo
 * @Description: TODO
 * @date 2018/8/2220:07
 */

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerA {

    @KafkaListener(topics = "__consumer_offsets" )
    public void processMessage(Object message) {
        System.out.println("Received offset message [" + message + "]");
    }

}

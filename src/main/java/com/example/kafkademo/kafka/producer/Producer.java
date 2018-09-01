package com.example.kafkademo.kafka.producer;

import com.example.kafkademo.kafka.SampleMessage;

/**
 * @author hx
 * @Title: Producer
 * @ProjectName kafka-demo
 * @Description: TODO
 * @date 2018/9/116:17
 */
public interface Producer {
    void send(SampleMessage message);
}

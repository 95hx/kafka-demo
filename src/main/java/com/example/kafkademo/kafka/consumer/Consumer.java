package com.example.kafkademo.kafka.consumer;

/**
 * @author hx
 * @Title: Consumer
 * @ProjectName kafka-demo
 * @Description: TODO
 * @date 2018/9/116:24
 */
public interface Consumer {
    void processMessage(Object message);
}

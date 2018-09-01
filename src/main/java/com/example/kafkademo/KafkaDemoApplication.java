package com.example.kafkademo;

import com.example.kafkademo.kafka.producer.impl.ProducerCommon;
import com.example.kafkademo.kafka.producer.Producer;
import com.example.kafkademo.kafka.producer.impl.ProducerReply;
import com.example.kafkademo.kafka.SampleMessage;
import org.apache.kafka.common.utils.SystemTime;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@SpringBootApplication
@RestController
public class KafkaDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaDemoApplication.class, args);
    }

    @Resource
    ProducerCommon producerCommon;


    @GetMapping("/send/{msg}")
    public SampleMessage sendMessage(@PathVariable("msg") String msg) {
        return send(producerCommon, msg);
    }

    @Resource
    ProducerReply producerReply;

    @GetMapping("/sendReply/{msg}")
    public SampleMessage sendReplyMessage(@PathVariable("msg") String msg) {
        return send(producerReply, msg);
    }

    public SampleMessage send(Producer producer, String msg) {
        SampleMessage message = new SampleMessage(System.nanoTime(), msg);
        producer.send(message);
        System.out.println(SystemTime.SYSTEM.nanoseconds());
        SystemTime.SYSTEM.sleep(1);
        return message;
    }

}

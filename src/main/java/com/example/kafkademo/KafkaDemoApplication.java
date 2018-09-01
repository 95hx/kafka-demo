package com.example.kafkademo;

import com.example.kafkademo.kafka.Producer;
import com.example.kafkademo.kafka.SampleMessage;
import org.apache.kafka.common.utils.SystemTime;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sun.plugin2.util.SystemUtil;

import javax.annotation.Resource;
import java.util.Random;


@SpringBootApplication
@RestController
public class KafkaDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaDemoApplication.class, args);
    }

    @Resource
    Producer producer;
    @GetMapping("/send/{msg}")
    public SampleMessage sendMessage(@PathVariable("msg") String msg) {
        SampleMessage message = new SampleMessage(System.nanoTime(), msg);
        producer.send(message);
        System.out.println(SystemTime.SYSTEM.nanoseconds());
        SystemTime.SYSTEM.sleep(1);
        return message;
    }

}

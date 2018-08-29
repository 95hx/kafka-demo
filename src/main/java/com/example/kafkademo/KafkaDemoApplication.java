package com.example.kafkademo;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class KafkaDemoApplication {

    @Autowired
    KafkaTemplate<String, String> producer;

    public static void main(String[] args) {
        SpringApplication.run(KafkaDemoApplication.class, args);
    }

    @RequestMapping("/{value}")
    String hello(@PathVariable(value = "value") String value) {
        producer.send("test", String.valueOf(value.hashCode()), value);
        return "生产者发送消息" + value + "到test";
    }

    @EnableKafka
    public static class Listener {
        protected final Logger logger = LoggerFactory.getLogger(this.getClass());

        @KafkaListener(groupId = "test",topics = {"test"})
        public void listen1(ConsumerRecord<?, ?> record) {
            System.out.println();
            logger.info("listen1");
            logger.info("来自kafka的key: " + record.key());
            logger.info("来自kafka的value: " + record.value().toString());
        }
        @KafkaListener(groupId = "test",topics = {"test"})
        public void listen2(ConsumerRecord<?, ?> record) {
            System.out.println();
            logger.info("listen2");
            logger.info("来自kafka的key: " + record.key());
            logger.info("来自kafka的value: " + record.value().toString());
        }
        @KafkaListener(groupId = "test",topics = {"test"})
        public void listen3(ConsumerRecord<?, ?> record) {
            System.out.println();
            logger.info("listen3");
            logger.info("来自kafka的key: " + record.key());
            logger.info("来自kafka的value: " + record.value().toString());
        }
    }
}

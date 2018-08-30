package com.example.kafkademo;

import com.google.gson.Gson;
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

import java.math.BigDecimal;

@SpringBootApplication
@RestController
public class KafkaDemoApplication {

    @Autowired
    KafkaTemplate<Object, String> producer;
    User user = new User(1L, "a320", "hx", 23, new BigDecimal(112));

    public static void main(String[] args) {
        SpringApplication.run(KafkaDemoApplication.class, args);
    }

    @RequestMapping("/{value}")
    String hello(@PathVariable(value = "value") String value) {
        //对象转json发送
        producer.send("test" + value, new Gson().toJson(user));
        return "生产者发送消息" + user + "到test" + value;
    }

    @EnableKafka
    public static class Listener {
        protected final Logger logger = LoggerFactory.getLogger(this.getClass());

        @KafkaListener(groupId = "test1", topics = {"${topicName}", "test2", "test3"})
        public void listen1(ConsumerRecord<?, ?> record) {
            logger.info("Consumer1来自kafka的" + "value:" + record.value().toString());
        }

        @KafkaListener(groupId = "test2", topics = {"test3", "test4", "test5"})
        public void Consumer2(ConsumerRecord<?, ?> record) {
            logger.info("Consumer2来自kafka的" + "value:" + record.value().toString());
        }

        @KafkaListener(groupId = "test2", topics = {"test5", "test6", "test7"})
        public void listen3(ConsumerRecord<?, ?> record) throws Exception {
            //json转对象
            logger.info(new Gson().fromJson(record.value().toString(), User.class).toString());
//            logger.info("Consumer3来自kafka的" + "value:" + record.value().toString());
        }
    }
}

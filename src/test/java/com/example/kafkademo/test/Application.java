package com.example.kafkademo.test;


import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaOperations.OperationsCallback;
import org.springframework.kafka.core.KafkaOperations;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.kafkademo.test")
public class Application implements CommandLineRunner {

    public static Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args).close();
    }

    @Autowired
    private KafkaTemplate<String, String> template;

    private final CountDownLatch latch = new CountDownLatch(3);

    @Override
    public void run(String... args) throws Exception {
        template.executeInTransaction((OperationsCallback<String, String, Object>) operations -> {
            operations.send("test", "data");
            return true;
        });
        ListenableFuture<SendResult<String, String>> future = this.template.send("myTopic", "foo1");
        /**
         * non block get result
         * (Async)
         */
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {

            @Override
            public void onSuccess(SendResult<String, String> result) {
                logger.info("result:" + result.toString());
            }

            @Override
            public void onFailure(Throwable ex) {
                logger.error(ex.getMessage());
            }

        });
        //block get result
//        SendResult<String, String> result = future.get();
        this.template.send("myTopic", "foo2");
        this.template.send("myTopic", "foo3");
        latch.await(60, TimeUnit.SECONDS);
        logger.info("All received");
    }

    @KafkaListener(topics = "myTopic")
    public void listen(ConsumerRecord<?, ?> cr) throws Exception {
        logger.info("get:" + cr.toString());//一条消息消费两次
        latch.countDown();
    }

    public void sendToKafka(final ProducerRecord<String, String> data) throws TimeoutException, InterruptedException {

        try {
            template.send(data).get(10, TimeUnit.SECONDS);
//            handleSuccess(data);
        } catch (ExecutionException e) {
//            handleFailure(data, record, e.getCause());
        }
    }
}

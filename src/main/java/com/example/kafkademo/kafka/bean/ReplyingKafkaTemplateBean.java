package com.example.kafkademo.kafka.bean;

import org.apache.kafka.common.Metric;
import org.apache.kafka.common.MetricName;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.listener.GenericMessageListenerContainer;
import org.springframework.kafka.requestreply.ReplyingKafkaTemplate;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author hx
 * @Title: ReplyingKafkaTemplateBean
 * @ProjectName kafka-demo
 * @Description: TODO
 * @date 2018/9/116:31
 */
//@Configuration
//public class DozerBeanMapperBean {
//    @Value("${server.port}")
//    private String getFromYml;
//
//    @ReplyingKafkaTemplateBean(name = "dozerBeanMapper", initMethod = "")
//    //proxyMode:容器启动时bean还没创建 通过cglib代理这个接口或者类注入到其它需要这个bean的bean中
//    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON,proxyMode = ScopedProxyMode.DEFAULT)
//    public DozerBeanMapper getDozerBeanMapper() {
//        System.out.println(getFromYml);
//        return new DozerBeanMapper();
//    }
//
//}
@Configuration
public class ReplyingKafkaTemplateBean {
    @Resource
    ProducerFactory producerFactory;

    @Bean
    public ReplyingKafkaTemplate getReplyingKafkaTemplate() {

        return new ReplyingKafkaTemplate(producerFactory, new GenericMessageListenerContainer() {
            @Override
            public void setupMessageListener(Object messageListener) {

            }

            @Override
            public Map<String, Map<MetricName, ? extends Metric>> metrics() {
                return null;
            }

            @Override
            public boolean isAutoStartup() {
                return false;
            }

            @Override
            public void stop(Runnable callback) {

            }

            @Override
            public void start() {

            }

            @Override
            public void stop() {

            }

            @Override
            public boolean isRunning() {
                return false;
            }

            @Override
            public int getPhase() {
                return 0;
            }
        });
    }
}

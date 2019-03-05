package com.oszhugc.mq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collection;
import java.util.Iterator;

@Configuration
public class MqConfig {

    @Value("${rabbitmq.queue.msg}")
    private String msgQueueName;

    @Value("${rabbitmq.queue.user}")
    private String userQueueName;


    @Bean
    public Queue createQueueMsg(){
        return new Queue(msgQueueName,true);
    }

    @Bean
    public Queue createQueueUser(){
        return new Queue(userQueueName,true);
    }

}

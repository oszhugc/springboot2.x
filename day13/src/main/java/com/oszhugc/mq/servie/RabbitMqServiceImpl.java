package com.oszhugc.mq.servie;

import com.oszhugc.mq.pojo.User;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class RabbitMqServiceImpl implements RabbitMqService, RabbitTemplate.ConfirmCallback {

    @Value("${rabbitmq.queue.user}")
    private String userRouting;

    @Value("${rabbitmq.queue.msg}")
    private String msgRouting;

    @Autowired
    private RabbitTemplate rabbitTemplate;


    @Override
    public void sendUser(User user) {
        System.out.println("发送用户消息 >>>> " + user);
        rabbitTemplate.setConfirmCallback(this);
        rabbitTemplate.convertAndSend(userRouting,user);
    }

    @Override
    public void sengMsg(String msg) {
        System.out.println("发送消息 >>>> " + msg);
        rabbitTemplate.setConfirmCallback(this);
        rabbitTemplate.convertAndSend(msgRouting,msg);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if (ack){
            System.out.println("消息消费成功....");
        }else{
            System.out.println("消息消费失败 >>>> " + cause);
        }
    }
}

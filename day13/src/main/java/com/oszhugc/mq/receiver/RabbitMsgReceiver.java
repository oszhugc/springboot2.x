package com.oszhugc.mq.receiver;

import com.oszhugc.mq.pojo.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMsgReceiver {


    @RabbitListener(queues = {"${rabbitmq.queue.msg}"})
    public void receiveMsg(String msg){
        System.out.println("收到消息 >>>> " + msg);
    }


    @RabbitListener(queues = {"${rabbitmq.queue.user}"})
    public void receiveUser(User user){
        System.out.println("收到用户消息 >>>> "+ user);
    }
}

package com.oszhugc.mq.controller;

import com.oszhugc.mq.pojo.User;
import com.oszhugc.mq.servie.RabbitMqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rabbitmq")
public class RabbitMqController {

    @Autowired
    private RabbitMqService rabbitMqService;

    @GetMapping("/msg")
    public String msg(String msg){
        rabbitMqService.sengMsg(msg);
        return "200";
    }

    @GetMapping("user")
    public String user(Long id,String username,String note){
        User user = new User(id,username,note);
        rabbitMqService.sendUser(user);
        return "200";
    }

}

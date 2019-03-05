package com.oszhugc.mq.servie;

import com.oszhugc.mq.pojo.User;

public interface RabbitMqService {

    void sengMsg(String msg);

    void sendUser(User user);
}

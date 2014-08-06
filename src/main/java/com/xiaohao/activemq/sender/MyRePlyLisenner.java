package com.xiaohao.activemq.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.*;

/**
 * Created by xiaohao on 2014/8/5.
 */
public class MyRePlyLisenner implements MessageListener {

    @Autowired
    JmsTemplate template;

    @Override
    public void onMessage(Message message){

        System.out.print("replay队列接收到消息： ");
        System.out.println(message.toString());



    }
}

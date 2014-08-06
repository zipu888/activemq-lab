package com.xiaohao.activemq.receiver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.*;

/**
 * Created by xiaohao on 2014/8/5.
 *
 */
public class MyRequestLisenner implements MessageListener {

    @Autowired
    JmsTemplate template;

    @Override
    public void onMessage(Message message) {

        System.out.print("request 队列 接收到消息：");
        System.out.println(message.toString());
        try{
            Destination destination =message.getJMSReplyTo();
            template.send(destination,new MessageCreator() {
                @Override
                public Message createMessage(Session session) throws JMSException {
                    Message message1 =session.createObjectMessage("test");
                    return message1;
                }
            });
        }catch (JMSException e){

        }
    }
}

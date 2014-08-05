package com.xiaohao.activemq.lisenner;

import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * Created by xiaohao on 2014/8/5.
 */
public class MyMessageLisenner implements MessageListener {

    @Override
    public void onMessage(Message message) {

        System.out.println("接收到消息");
        System.out.println(message.toString());

    }
}

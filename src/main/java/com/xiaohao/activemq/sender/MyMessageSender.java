package com.xiaohao.activemq.sender;

import com.xiaohao.activemq.message.MsgObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by xiaohao on 2014/8/5.
 */
public class MyMessageSender {

    JmsTemplate template;

    Destination requestDestination;

    Destination responseDestination;

    @PostConstruct
    public void send(){
        MsgObj msg = new MsgObj();
        msg.setMessageCode(110);
        msg.setMessageContent("有色狼");
        Timer t =new Timer("test");
        t.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                while (true){
                    template.send(requestDestination,new MessageCreator() {
                        @Override
                        public Message createMessage(Session session) throws JMSException {
                            Message msg =session.createTextMessage("有色狼");
                            msg.setJMSMessageID("110");
                            msg.setJMSReplyTo(responseDestination);
                            return msg;
                        }
                    });
                    try {
                        Thread.sleep(2000);
                    }catch (Exception e){

                    }

                }

            }
        },5000,2000);

    }

    public JmsTemplate getTemplate() {
        return template;
    }

    public void setTemplate(JmsTemplate template) {
        this.template = template;
    }

    public Destination getRequestDestination() {
        return requestDestination;
    }

    public void setRequestDestination(Destination requestDestination) {
        this.requestDestination = requestDestination;
    }

    public Destination getResponseDestination() {
        return responseDestination;
    }

    public void setResponseDestination(Destination responseDestination) {
        this.responseDestination = responseDestination;
    }
}

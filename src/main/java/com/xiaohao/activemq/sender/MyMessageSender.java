package com.xiaohao.activemq.sender;

import com.xiaohao.activemq.message.MsgObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.jms.Destination;

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
        template.convertAndSend(msg);
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

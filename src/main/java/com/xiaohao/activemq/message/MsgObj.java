package com.xiaohao.activemq.message;

import java.io.Serializable;

/**
 * Created by xiaohao on 2014/8/5.
 */
public class MsgObj implements Serializable {

    private int messageCode;

    private String messageContent;

    public int getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(int messageCode) {
        this.messageCode = messageCode;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }
}

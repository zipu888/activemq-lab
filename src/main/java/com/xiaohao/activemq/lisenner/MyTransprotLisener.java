package com.xiaohao.activemq.lisenner;

import org.apache.activemq.transport.TransportListener;

import java.io.IOException;

/**
 * Created by Administrator on 15-5-29.
 */
public class MyTransprotLisener implements TransportListener {

    @Override
    public void onCommand(Object o) {
        System.out.println("onCommand");
    }

    @Override
    public void onException(IOException e) {
        System.out.println("onException");
    }

    @Override
    public void transportInterupted() {
        System.out.println("transportInterupted");
    }

    @Override
    public void transportResumed() {
        System.out.println("transportResumed");
    }
}

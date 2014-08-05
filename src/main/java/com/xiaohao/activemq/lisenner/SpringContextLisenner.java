package com.xiaohao.activemq.lisenner;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by xiaohao on 2014/8/5.
 */
public class SpringContextLisenner implements ApplicationListener {

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        System.out.println("application lisenner:" + applicationEvent.toString());
    }
}

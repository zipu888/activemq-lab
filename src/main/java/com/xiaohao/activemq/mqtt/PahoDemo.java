package com.xiaohao.activemq.mqtt;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 * Created by Administrator on 15-5-29.
 */
public class PahoDemo {
    public static MqttClient client;
    public static void main(String[] args){

        try {
            client = new MqttClient("tcp://localhost:1883", "mqttClienttest");
            client.connect();
            MqttMessage message = new MqttMessage();
            message.setPayload("A single message".getBytes());
            client.publish("pahodemo/test", message);
            Thread.sleep(900000);
            client.disconnect();
        } catch (MqttException e) {
            e.printStackTrace();
        }catch (InterruptedException e1){
            e1.printStackTrace();
        }

    }

}

package com.xiaohao.activemq.mqtt;

import org.eclipse.paho.client.mqttv3.*;

/**
 * Created by Administrator on 15-5-29.
 */
public class PahoSubDemo {
    public static MqttClient client;
    public static void main(String[] args){

        try {
            client = new MqttClient("tcp://localhost:1883", "mqttClienttest");
            client.connect();
            MqttMessage message = new MqttMessage();
            message.setPayload("A single message".getBytes());
            client.subscribe("pahodemo/test");
            client.setCallback(new MqttCallback() {
                @Override
                public void connectionLost(Throwable throwable) {

                }

                @Override
                public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
                    System.out.println("s:"+s);
                    System.out.println("mqttmsg:"+mqttMessage);
                }

                @Override
                public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

                }
            });
            Thread.sleep(100000);
            client.disconnect();
        } catch (MqttException e) {
            e.printStackTrace();
        }catch (InterruptedException e1){
            e1.printStackTrace();
        }

    }
}

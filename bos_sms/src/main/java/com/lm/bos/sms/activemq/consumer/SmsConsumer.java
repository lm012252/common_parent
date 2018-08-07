package com.lm.bos.sms.activemq.consumer;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

public class SmsConsumer implements MessageListener {
    @Override
    public void onMessage(Message message) {
        MapMessage mapMessage = (MapMessage) message;
        try {
            String telephone = mapMessage.getString("telephone");
            String content = mapMessage.getString("content");
            //调用短信接口，发送短信给用户
            System.out.println("手机号："+telephone+"短信内容："+content);
//           SmsUtils.sendSms(telephone);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

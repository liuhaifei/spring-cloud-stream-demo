package com.springcloud.stream.server.service;


import com.springcloud.stream.server.customiz.UserMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.UnsupportedEncodingException;


@Service
public class UserMessageService {

    @Autowired
    private UserMessage userMessage;

    @ServiceActivator(inputChannel = "test")
    public void listen(java.lang.String message)  {
        System.out.println("Subscribe by @ServiceActivator:"+message);
    }

    @StreamListener("test")
    public void onMessage(String message)  {
        System.out.println("Subscribe by @StreamListener:"+message);
    }
    @StreamListener("input")
    public void input(String message)  {
        System.out.println("Subscribe by @input:"+message);
    }



    @PostConstruct
    public void init() {
        SubscribableChannel subscribableChannel = userMessage.input();
        subscribableChannel.subscribe(message -> {
            try {
                System.out.println("Subscribe by SubscribableChannel:"+new String((byte[])message.getPayload(),"UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        });
    }

    @StreamListener("http")  // Spring Cloud Stream 注解驱动
    public void testHttp(String message) {
        System.out.println("testHttp(String): " + message);
    }
}

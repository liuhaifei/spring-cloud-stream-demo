package com.springcloud.stream.server.service;


import com.springcloud.stream.server.customiz.UserMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;


@Service
public class UserMessageService {




//    @ServiceActivator(inputChannel = "user-message")
//    public void listen(java.lang.String message)  {
//        System.out.println("Subscribe by @ServiceActivator:"+message);
//    }

    @StreamListener("test")
    public void onMessage(String message)  {
        System.out.println("Subscribe by @StreamListener:"+message);
    }
    @StreamListener("input")
    public void input(String message)  {
        System.out.println("Subscribe by @input:"+message);
    }
//    @StreamListener("01test")  // Spring Cloud Stream 注解驱动
//    public void test(String message) {
//        System.out.println("01test(String): " + message);
//    }

//
//    @PostConstruct
//    public void init() {
//        SubscribableChannel subscribableChannel = userMessage.input();
//        subscribableChannel.subscribe(message -> {
//            System.out.println("Subscribe by SubscribableChannel:"+message);
//        });
//    }
}

package com.springcloud.stream.server.service;


import com.springcloud.stream.server.customiz.UserMessage;
import com.sun.org.apache.xpath.internal.operations.String;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;

import static com.springcloud.stream.server.customiz.UserMessage.INPUT;

@Service
public class UserMessageService {

    @Autowired
    private UserMessage userMessage;

    @ServiceActivator(inputChannel = INPUT)
    public void listen(byte[] data)  {
        System.out.println("Subscribe by @ServiceActivator:"+data.toString());
    }

    @StreamListener(INPUT)
    public void onMessage(byte[] data)  {
        System.out.println("Subscribe by @StreamListener:"+data.toString());
    }

    @PostConstruct
    public void init() {
        SubscribableChannel subscribableChannel = userMessage.input();
        subscribableChannel.subscribe(message -> {
            System.out.println("Subscribe by SubscribableChannel:"+message);
        });
    }
}

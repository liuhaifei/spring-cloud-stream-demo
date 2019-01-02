package com.springcloud.stream.client.controller;


import com.springcloud.stream.client.customiz.UserMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserServiceClientController {

    @Autowired
    private UserMessage userMessage;
    @Autowired
    private Source source;


    @GetMapping("/user/message/rabbit")
    public boolean saveUserByRabbitMessage(@RequestParam String message) {
        MessageChannel messageChannel = userMessage.output();
        // 发送消息
        return messageChannel.send(new GenericMessage<String>(message));
    }

    @GetMapping("/user/message/source")
    public boolean source(@RequestParam String message) {
        MessageChannel messageChannel = source.output();
        // 发送消息
        return messageChannel.send(new GenericMessage<String>(message));
    }

    @GetMapping("/send/http")
    public boolean testHttp(@RequestParam String message){
        MessageChannel messageChannel= userMessage.http();
        return messageChannel.send(new GenericMessage("http ->send:"+message));
    }
}

package com.springcloud.stream.client.controller;


import com.springcloud.stream.client.customiz.UserMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserServiceClientController {

    @Autowired
    private UserMessage userMessage;


    @PostMapping("/user/message/rabbit")
    public boolean saveUserByRabbitMessage(@RequestParam String message) {
        MessageChannel messageChannel = userMessage.output();
        GenericMessage<String> genericMessage =
                            new GenericMessage<String>(message);
        // 发送消息
        return messageChannel.send(genericMessage);
    }
}

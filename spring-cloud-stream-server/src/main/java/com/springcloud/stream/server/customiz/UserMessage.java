package com.springcloud.stream.server.customiz;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface UserMessage {

    String INPUT = "user-message";

    @Input(INPUT)
        // 管道名称
    SubscribableChannel input();
}
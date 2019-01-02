package com.springcloud.stream.client.customiz;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface UserMessage {

    @Output("stream")
    MessageChannel output();

}


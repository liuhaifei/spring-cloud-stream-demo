package com.springcloud.stream.server.customiz;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface UserMessage {


    @Input("test") // 管道名称
    SubscribableChannel input();

    @Input("http")  //自定义http管道
    SubscribableChannel http();

}

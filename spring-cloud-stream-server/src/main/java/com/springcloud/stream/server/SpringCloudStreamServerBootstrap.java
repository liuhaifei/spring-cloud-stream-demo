package com.springcloud.stream.server;

import com.springcloud.stream.server.customiz.UserMessage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;

/**
 * @ClassName SpringCloudStreamServerBootstrap
 * @Description TODO
 * @Author 刘海飞
 * @Date 2018/12/29 17:33
 * @Version 1.0
 **/
@SpringBootApplication
@EnableBinding({UserMessage.class,Sink.class})
public class SpringCloudStreamServerBootstrap {

    public static void main(String[] args) {
        new SpringApplicationBuilder(SpringCloudStreamServerBootstrap.class)
                .run(args);
    }
}

package com.springcloud.stream.client;

import com.springcloud.stream.client.customiz.UserMessage;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;

/**
 * @ClassName SpringCloudStreamClientBootstrap
 * @Description TODO
 * @Author 刘海飞
 * @Date 2018/12/29 17:31
 * @Version 1.0
 **/
@SpringBootApplication
@EnableBinding({UserMessage.class,Source.class})
public class SpringCloudStreamClientBootstrap {

    public static void main(String[] args) {
            new SpringApplicationBuilder(SpringCloudStreamClientBootstrap.class)
                    .run(args);
    }
}

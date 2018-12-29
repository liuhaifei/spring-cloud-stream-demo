package com.springcloud.stream.server;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @ClassName SpringCloudStreamServerBootstrap
 * @Description TODO
 * @Author 刘海飞
 * @Date 2018/12/29 17:33
 * @Version 1.0
 **/
@SpringBootApplication
public class SpringCloudStreamServerBootstrap {

    public static void main(String[] args) {
        new SpringApplicationBuilder(SpringCloudStreamServerBootstrap.class)
                .run(args);
    }
}

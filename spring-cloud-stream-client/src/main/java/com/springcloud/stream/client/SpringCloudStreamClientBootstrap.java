package com.springcloud.stream.client;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @ClassName SpringCloudStreamClientBootstrap
 * @Description TODO
 * @Author 刘海飞
 * @Date 2018/12/29 17:31
 * @Version 1.0
 **/
@SpringBootApplication
public class SpringCloudStreamClientBootstrap {

    public static void main(String[] args) {
            new SpringApplicationBuilder(SpringCloudStreamClientBootstrap.class)
                    .run(args);
    }
}

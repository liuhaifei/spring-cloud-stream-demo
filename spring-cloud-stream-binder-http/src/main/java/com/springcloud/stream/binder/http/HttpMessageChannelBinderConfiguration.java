package com.springcloud.stream.binder.http;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName RocketMQMessageChannelBinderConfiguration
 * @Description TODO
 * @Author 刘海飞
 * @Version 1.0
 **/
@Configuration
public class HttpMessageChannelBinderConfiguration {

    @Bean
    public HttpMessageChannelBinder rocketMQMessageChannelBinder(
            MessageReceiverController controller){
        return new HttpMessageChannelBinder(controller);
    }
}

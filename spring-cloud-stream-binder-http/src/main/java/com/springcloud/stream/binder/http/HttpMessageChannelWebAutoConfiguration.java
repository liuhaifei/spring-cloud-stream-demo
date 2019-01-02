package com.springcloud.stream.binder.http;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
public class HttpMessageChannelWebAutoConfiguration {

    @Bean
    public MessageReceiverController controller(){
        return new MessageReceiverController();
    }
}
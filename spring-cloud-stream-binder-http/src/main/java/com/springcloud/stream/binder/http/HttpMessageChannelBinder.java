package com.springcloud.stream.binder.http;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.stream.binder.Binder;
import org.springframework.cloud.stream.binder.Binding;
import org.springframework.cloud.stream.binder.ConsumerProperties;
import org.springframework.cloud.stream.binder.ProducerProperties;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.web.client.RestTemplate;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Random;

/**
 * @ClassName HttpMessageChannelBinder
 * @Description TODO
 * @Author 刘海飞
 * @Version 1.0
 **/
public class HttpMessageChannelBinder implements Binder<MessageChannel, ConsumerProperties, ProducerProperties> {

    private static final String ROOT_URL="http://127.0.0.1:8081";

    private MessageReceiverController controller;

    public HttpMessageChannelBinder( MessageReceiverController controller) {
        this.controller = controller;
    }


    @Override
    public Binding<MessageChannel> bindConsumer(String name, String group, MessageChannel inputChannel, ConsumerProperties consumerProperties) {
        //给controller注入 MessageChannel
        controller.setMessageChannel(inputChannel);
        return null;
    }

    @Override
    public Binding<MessageChannel> bindProducer(String name, MessageChannel outputChannel, ProducerProperties producerProperties) {

        RestTemplate restTemplate = new RestTemplate();

        SubscribableChannel subscribableChannel = (SubscribableChannel) outputChannel;

        subscribableChannel.subscribe(message -> {
            //消息体
            byte[] messageBody = (byte[]) message.getPayload();
            //ENDPOINT URI:/message/receive
            String targetURI = ROOT_URL + MessageReceiverController.ENDPOINT_URI;
            //请求实体 post
            try {
                RequestEntity requestEntity = new RequestEntity(messageBody, HttpMethod.POST, new URI(targetURI));
                restTemplate.exchange(requestEntity, String.class);
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        });
        return null;
    }

}

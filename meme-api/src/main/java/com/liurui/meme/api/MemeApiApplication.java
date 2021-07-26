package com.liurui.meme.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class MemeApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MemeApiApplication.class, args);
    }

}

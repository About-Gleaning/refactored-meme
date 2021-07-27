package com.liurui.meme.api;

import com.liurui.meme.api.core.config.FeignConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.liurui.meme.api.feign", defaultConfiguration = FeignConfigurer.class)
@EnableDiscoveryClient
@SpringBootApplication
public class MemeApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MemeApiApplication.class, args);
    }

}

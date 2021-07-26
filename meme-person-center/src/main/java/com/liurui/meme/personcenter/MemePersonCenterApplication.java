package com.liurui.meme.personcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class MemePersonCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(MemePersonCenterApplication.class, args);
    }

}

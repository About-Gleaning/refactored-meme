package com.liurui.meme.personcenter.service;

import org.springframework.stereotype.Service;

/**
 * @Description: TODO
 * @Datatime: 2021/7/26 21:31
 * @Author: 渣渣瑞
 */
@Service
public class DemoService {

    public String sayHello(String say) {
        return "say hello: " + say;
    }

}

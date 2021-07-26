package com.liurui.meme.api.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.liurui.meme.api.core.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/demo")
public class DemoController extends BaseController {

    @NacosValue(value = "${useLocalCache:false}", autoRefreshed = true)
    private boolean useLocalCache;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/demo")
    public String demo() {
        var userContext = getUserContext();
        return userContext.getUserId();
    }

}

package com.liurui.meme.api.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.liurui.arsenal.base.web.bean.result.ResultBean;
import com.liurui.meme.api.core.base.BaseController;
import com.liurui.meme.api.feign.DemoFeignClient;
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
    @Autowired
    private DemoFeignClient demoFeignClient;

    @RequestMapping("/restemplate")
    public String restemplate() {
        var userContext = getUserContext();
        ResultBean result = restTemplate.getForObject("http://meme-person-center/demo/sayhello/{0}", ResultBean.class, "haha");
        return (String) result.getData();
    }

    @RequestMapping("/feign")
    public ResultBean<String> feign() {
        return demoFeignClient.sayHello("hehe");
    }

}

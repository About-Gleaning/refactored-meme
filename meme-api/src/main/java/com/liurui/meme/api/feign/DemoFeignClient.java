package com.liurui.meme.api.feign;

import com.liurui.arsenal.base.web.bean.result.ResultBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Description: TODO
 * @Datatime: 2021/7/26 22:31
 * @Author: 渣渣瑞
 */
@FeignClient(name = "meme-person-center")
public interface DemoFeignClient {

    @RequestMapping(value = "/demo/sayhello/{say}", method = RequestMethod.GET)
    public ResultBean<String> sayHello(@PathVariable("say")String say);

}

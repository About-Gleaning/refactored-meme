package com.liurui.meme.api.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.liurui.arsenal.base.web.bean.person.UserContext;
import com.liurui.arsenal.base.web.bean.result.BaseResult;
import com.liurui.meme.api.core.base.BaseController;
import com.liurui.meme.api.feign.DemoFeignClient;
import com.liurui.meme.bean.demo.Demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
        BaseResult result = restTemplate.getForObject("http://meme-person-center/demo/sayhello/{0}", BaseResult.class, "haha");
        return (String) result.getData();
    }

    /**
     * url路径参数类型demo
     * @return
     */
    @RequestMapping("/feign/pathvariable/{say}")
    public BaseResult<String> pathvariable(@PathVariable("say") String say) {
        return demoFeignClient.pathvariable(say);
    }

    @RequestMapping("/feign/get")
    public BaseResult<String> get(String say) {
        return demoFeignClient.get(say);
    }

    @RequestMapping("/feign/get_requestLine")
    public BaseResult<String> get_requestLine(String say) {
        return demoFeignClient.get(say);
    }

    @RequestMapping("/feign/get2")
    public BaseResult<UserContext> get2(UserContext userContext) {
        return demoFeignClient.get2(userContext);
    }

    @RequestMapping("/feign/post_form")
    public BaseResult<Demo> post_form(Demo demo) {
        return demoFeignClient.post_form(demo);
    }

    @RequestMapping("/feign/post_form2")
    public BaseResult<Demo> post_form2(String name, Integer age) {
        return demoFeignClient.post_form2(name, age);
    }

    @RequestMapping("/feign/post_form3")
    public BaseResult<Demo> post_form3(Demo demo, String name2, Integer age2) {
        return demoFeignClient.post_form3(demo, name2, age2);
    }

    @RequestMapping("/feign/post_json")
    public BaseResult<Demo> post_json(@RequestBody Demo demo) {
        System.out.println(demo.toString());
        return demoFeignClient.post_json(demo);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        System.out.println(arr[4]);
    }

}

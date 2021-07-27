package com.liurui.meme.api.feign;

import com.liurui.arsenal.base.web.bean.person.UserContext;
import com.liurui.arsenal.base.web.bean.result.ResultBean;
import com.liurui.meme.bean.demo.Demo;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;

/**
 * @Description: TODO
 * @Datatime: 2021/7/26 22:31
 * @Author: 渣渣瑞
 */
@FeignClient(name = "meme-person-center", path = "/demo/feign")
public interface DemoFeignClient {

//    @RequestLine("GET /feign/get")
//    ResultBean<String> get_requestLine(String say);

    /**
     * get url路径参数
     */
    @RequestMapping(value = "/pathvariable/{say}", method = RequestMethod.GET)
    ResultBean<String> pathvariable(@PathVariable("say")String say);

    /**
     * get 普通参数
     */
    @GetMapping(value = "/get")
    ResultBean<String> get(String say);

    /**
     * get 参数为对象格式
     * feign @QueryMap 与Spring不兼容，因为缺少value属性
     * 所以用 Spring Cloud OpenFeign 提供的@SpringQueryMap
     */
    @GetMapping(value = "/get2")
    ResultBean<UserContext> get2(@SpringQueryMap UserContext userContext);

    /**
     * post 表单 对象参数
     * 此时服务端的 @RequestBody 注解不能省
     * 入参 @RequestBody只能支持一个，多个会报：Method has too many Body parameters
     * 但是可以有多个 @RequestParam
     * 入参的 @RequestBody 可以省
     */
    @PostMapping(value = "/post_form")
    ResultBean<Demo> post_form(@RequestBody Demo demo);

    /**
     * post 表单 普通参数
     * 入参的 @RequestParam 不能省
     */
    @PostMapping(value = "/post_form2")
    ResultBean<Demo> post_form2(@RequestParam String name, @RequestParam Integer age);

    /**
     * post 表单 对象参数 + 普通参数
     * @RequestBody只能有一个，@RequestParam 可以有多个
     * 入参的 @RequestBody 可以省
     */
    @PostMapping(value = "/post_form3")
    ResultBean<Demo> post_form3(@RequestBody Demo demo, @RequestParam String name2, @RequestParam Integer age2);

    /**
     * post json
     * 指定提交方式为json
     * 入参的 @RequestBody 可以省
     * header指定提交方式
     */
    @PostMapping(value = "/post_json")
    @Headers({"Content-Type: application/json"})
    ResultBean<Demo> post_json(Demo demo);
}

package com.liurui.meme.personcenter.action;

import com.liurui.arsenal.base.web.bean.person.UserContext;
import com.liurui.arsenal.base.web.bean.result.ResultBean;
import com.liurui.meme.bean.demo.Demo;
import com.liurui.meme.personcenter.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description: TODO
 * @Datatime: 2021/7/26 21:31
 * @Author: 渣渣瑞
 */
@RestController
@RequestMapping("/demo")
public class DemoAction {

    @Autowired
    private DemoService demoService;

    @GetMapping("/feign/pathvariable/{say}")
    public ResultBean<String> sayHello(@PathVariable("say") String say) {
        return ResultBean.succuess(demoService.sayHello(say));
    }

    @GetMapping("/feign/get")
    public ResultBean<String> get(String say) {
        return ResultBean.succuess(demoService.sayHello(say));
    }

    @GetMapping("/feign/get2")
    public ResultBean<UserContext> get2(UserContext userContext) {
        userContext.setUserId("11").setUserName("22").setToken("33");
        return ResultBean.succuess(userContext);
    }

    @RequestMapping("/feign/post_form")
    public ResultBean<Demo> post_form(@RequestBody Demo demo) {
        demo.setName(demo.getName() + demo.getAge());
        return ResultBean.succuess(demo);
    }

    @RequestMapping("/feign/post_form2")
    public ResultBean<Demo> post_form2(String name, Integer age) {
        Demo demo = new Demo();
        demo.setName(name);
        demo.setAge(age);
        return ResultBean.succuess(demo);
    }

    @RequestMapping("/feign/post_form3")
    public ResultBean<Demo> post_form3(@RequestBody Demo demo, String name2, Integer age2) {
        demo.setName(demo.getName() + name2);
        demo.setAge(demo.getAge() + age2);
        return ResultBean.succuess(demo);
    }

    @RequestMapping("/feign/post_json")
    public ResultBean<Demo> post_json(@RequestBody Demo demo) {
        demo.setName(demo.getName() + demo.getAge());
        demo.setAge(18);
        return ResultBean.succuess(demo);
    }

}

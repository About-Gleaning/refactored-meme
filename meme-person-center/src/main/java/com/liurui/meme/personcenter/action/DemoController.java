package com.liurui.meme.personcenter.action;

import com.liurui.arsenal.base.web.bean.result.ResultBean;
import com.liurui.meme.personcenter.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: TODO
 * @Datatime: 2021/7/26 21:31
 * @Author: 渣渣瑞
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @RequestMapping("/sayhello/{say}")
    public ResultBean<String> sayHello(@PathVariable("say") String say) {
        return ResultBean.succuess(demoService.sayHello(say));
    }

}

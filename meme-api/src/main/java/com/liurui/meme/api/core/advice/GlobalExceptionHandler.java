package com.liurui.meme.api.core.advice;

import com.liurui.arsenal.base.web.bean.result.ResultBean;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @ClassName GlobalExceptionHandler
 * @Description 全局异常处理
 * @Author liurui
 * @Date 2021/7/26 10:54 上午
 * @Version 1.0
 **/
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResultBean exception(Exception e) {
        e.printStackTrace();
        return ResultBean.fail();
    }

}

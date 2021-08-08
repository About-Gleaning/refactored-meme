package com.liurui.meme.api.core.advice;

import com.liurui.arsenal.base.web.bean.enums.ErrorCodeMsg;
import com.liurui.arsenal.base.web.bean.result.BaseResult;
import com.liurui.arsenal.base.web.exception.api.ApiException;
import com.liurui.arsenal.base.web.exception.business.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @ClassName GlobalExceptionHandler
 * @Description 全局异常处理
 * @Author liurui
 * @Date 2021/7/26 10:54 上午
 * @Version 1.0
 **/
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * api异常
     * @param e
     * @return
     */
    @ExceptionHandler(ApiException.class)
    public BaseResult apiException(Exception e) {
        LOGGER.error("apiException error", e);
        return BaseResult.fail(ErrorCodeMsg.API_ERROR);
    }

    /**
     * 业务异常
     * @param e
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    public BaseResult businessException(Exception e) {
        LOGGER.error("businessException error", e);
        return BaseResult.fail(ErrorCodeMsg.BUSINESS_ERROR);
    }

    /**
     * 未知异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public BaseResult exception(Exception e) {
        LOGGER.error("application error", e);
        return BaseResult.fail(ErrorCodeMsg.APPLICATION_ERROR);
    }

}

package com.zhoutong.learn.exception;

import com.zhoutong.learn.model.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
/*
 * 全局异常处理
 */
@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(Exception.class)
    public Result getException(Exception e) {
        e.printStackTrace();
        return Result.errorResult("服务器异常");
    }

}

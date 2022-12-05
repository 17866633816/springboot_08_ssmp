package com.itheima.controller.util;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//SpringMVC的异常处理器
@RestControllerAdvice
public class ProjectExceptionAdvice {
    @ExceptionHandler(Exception.class)
    public R doException(Exception ex){
        //1.打印日志
        //2.通知运维人员
        //3.通知开发人员
        ex.printStackTrace();
        return new R(false,null,"服务器出现异常，请稍后再试！");
    }
}

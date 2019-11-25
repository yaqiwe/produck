package com.example.produck.exception;

import com.example.produck.dto.Resoult;
import com.example.produck.enums.exceptionEnum;
import com.example.produck.util.ResoultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/11/23 14:23
 * @description：异常拦截
 */
@ControllerAdvice
@ResponseBody
public class exceptionHandle {

    @ExceptionHandler(Exception.class)
    public Resoult errorHandler(Exception e) {
        /*自定义的错误类型*/
        if (e instanceof productException) {
            productException ce = (productException) e;
            return ResoultUtil.error(ce.getCode(), ce.getMessage());
        }
        //其他异常，打印控制台
        e.printStackTrace();
        return ResoultUtil.error(exceptionEnum.UNKNOWN_ERROR);
    }
}

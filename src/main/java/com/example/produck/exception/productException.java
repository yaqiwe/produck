package com.example.produck.exception;

import com.example.produck.enums.exceptionEnum;
import lombok.Data;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/11/23 14:20
 * @description：
 */
@Data
public class productException extends RuntimeException{
    private Integer code;

    public productException(exceptionEnum enums){
        super(enums.getMsg());
        code=enums.getCode();
    }
}

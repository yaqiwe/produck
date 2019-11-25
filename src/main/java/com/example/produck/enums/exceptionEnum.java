package com.example.produck.enums;

import lombok.Getter;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/11/22 12:45
 * @description：
 */
@Getter
public enum exceptionEnum {
    UNKNOWN_ERROR(501,"未知错误"),

    PRODUCT_NULL(6001,"商品不存在"),
    PRODUCT_DOWN_SHELF(6002,"该商品已下架"),
    PROUDUCT_INSUFFICIENT(6003,"商品库存不足"),
    ;

    private String msg;

    private Integer code;

    exceptionEnum(Integer code,String msg){
        this.code=code;
        this.msg=msg;
    }
}

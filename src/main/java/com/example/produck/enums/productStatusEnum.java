package com.example.produck.enums;

import lombok.Getter;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/11/22 10:24
 * @description：商品状态枚举
 */
@Getter
public enum productStatusEnum {
    UP_SHELF(0,"在架的商品"),
    DOWN_SHELF(1,"下架的商品"),
    ;

    private String msg;

    private Integer code;

    productStatusEnum(Integer code,String msg){
        this.code=code;
        this.msg=msg;
    }
}

package com.example.produck.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/11/22 13:08
 * @description：商品详细详细Dto
 */
@Data
public class productInfoDto {

    @JsonProperty("id")
    private String productId;   //商品Id

    @JsonProperty("name")
    private String productName;     //商品名称

    @JsonProperty("price")
    private BigDecimal productPrice;        //商品单价

    @JsonProperty("description")
    private String productDescription;      //描述

    @JsonProperty("icon")
    private String productIcon;     //小图的Url
}

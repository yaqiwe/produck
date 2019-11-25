package com.example.produck.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/11/23 14:10
 * @description：商品扣库存的DTO
 */
@Data
public class CartDto {

    @NotBlank
    private String productId;       //商品ID

    private Integer productQuantity;        //扣除的库存

}

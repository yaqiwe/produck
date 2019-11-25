package com.example.produck.service;

import com.example.produck.dto.CartDto;
import com.example.produck.dto.productInfoDto;
import com.example.produck.entity.productInfo;

import java.util.List;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/11/22 9:47
 * @description：商品详情操作
 */
public interface productInfoService {

    /**
     * 查询所有在架商品
     * @return
     */
    List<productInfo> findUpAll();

    /**
     * 根据商品Id查询相关商品信息
     * @param productIdList
     * @return
     */
    List<productInfoDto> finByProductIdIn(List<String> productIdList);

    /**
     * 扣除商品的信息
     * @param cartDtos
     */
    void decreaseStock(List<CartDto> cartDtos);
}


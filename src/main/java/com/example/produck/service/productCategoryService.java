package com.example.produck.service;

import com.example.produck.entity.productCategory;

import java.util.List;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/11/22 12:29
 * @description：商品类目操作
 */
public interface productCategoryService {

    /**
     * 根据CategoryType查找类目信息
     * @param CategoryTypeList
     * @return
     */
    List<productCategory> findByCategoryTypeIn(List<Integer> CategoryTypeList);
}

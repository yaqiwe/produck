package com.example.produck.service.impl;

import com.example.produck.ProduckApplicationTests;
import com.example.produck.entity.productCategory;
import com.example.produck.service.productCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/11/22 12:37
 * @description：
 */
@Component
@Slf4j
class productCategoryServiceImplTest extends ProduckApplicationTests{
    @Autowired
    productCategoryService productCategoryS;

    @Test
    void testFindByCate(){
        List<Integer> CategoryTypeList=new ArrayList<>();
        CategoryTypeList.add(1);
        CategoryTypeList.add(2);
        List<productCategory> byCategoryTypeIn = productCategoryS.findByCategoryTypeIn(CategoryTypeList);
        log.info("findByCategoryTypeInTest------:{}",byCategoryTypeIn);
        Assert.assertEquals(CategoryTypeList.size(),byCategoryTypeIn.size());
    }
}
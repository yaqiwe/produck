package com.example.produck.repository;

import com.example.produck.ProduckApplicationTests;
import com.example.produck.entity.productCategory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/11/22 9:55
 * @description：
 */

@Component
@Slf4j
class productCategoryRepositoryTest  extends ProduckApplicationTests {
    @Autowired
    productCategoryRepository productCategoryR;

    @Test
    void selectAll(){
        //查询
        List<productCategory> all = productCategoryR.findAll();
        Assert.assertNotEquals(all.size(),0);
    }

    @Test
    @Transactional
    void saveCate(){
        //增加
        productCategory category=new productCategory();
        category.setCategoryName("商品类目测试");
        category.setCategoryType(500);
        productCategory save = productCategoryR.save(category);
        Assert.assertEquals(save.getCategoryName(),category.getCategoryName());
    }

    @Test
    @Transactional
    void updateCate(){
        List<productCategory> all = productCategoryR.findAll();
        all.get(0).setCategoryName("修改商品类目查询");
        productCategory save = productCategoryR.save(all.get(0));
        Assert.assertEquals(all.get(0).getCategoryName(),save.getCategoryName());
    }

    @Test
    void findByCategoryTypeInTest(){
        List<Integer> CategoryTypeList=new ArrayList<>();
        CategoryTypeList.add(1);
        CategoryTypeList.add(2);
        List<productCategory> byCategoryTypeIn = productCategoryR.findByCategoryTypeIn(CategoryTypeList);
        log.info("findByCategoryTypeInTest------:{}",byCategoryTypeIn);
        Assert.assertEquals(CategoryTypeList.size(),byCategoryTypeIn.size());
    }
}
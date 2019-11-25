package com.example.produck.repository;

import com.example.produck.ProduckApplicationTests;
import com.example.produck.entity.productInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/11/20 21:41
 * @description：
 */
@Slf4j
@Component
class productInfoRepositoryTest  extends ProduckApplicationTests {

    @Autowired
    productInfoRepository productInfoR;

    @Test
    void findByProductStatus() {
        List<productInfo> pa = productInfoR.findByProductStatus(1);
        log.info("findByProductStatus: {}",pa);
        Assert.assertNotEquals(0,pa.size());
    }

    @Test
    void findByProductIdIn(){
        List<String> productId=new ArrayList<>();
        productId.add("0001");
        productId.add("0003");
        List<productInfo> byProductIdIn = productInfoR.findByProductIdIn(productId);
        log.info("findByProductIdIn productList",byProductIdIn);
        Assert.assertTrue(byProductIdIn.size()>0);
    }
}
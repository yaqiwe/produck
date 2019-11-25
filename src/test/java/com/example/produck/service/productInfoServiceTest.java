package com.example.produck.service;

import com.example.produck.ProduckApplicationTests;
import com.example.produck.dto.CartDto;
import com.example.produck.entity.productInfo;
import com.example.produck.enums.exceptionEnum;
import com.example.produck.enums.productStatusEnum;
import com.example.produck.exception.productException;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/11/22 10:39
 * @description：
 */
@Component
class productInfoServiceTest  extends ProduckApplicationTests {
    @Autowired
    productInfoService productInfoS;

    @Test
    void findUpAll() {
        List<productInfo> list = productInfoS.findUpAll();
        for (productInfo productInfo : list) {
            Assert.assertEquals(productInfo.getProductStatus(), productStatusEnum.UP_SHELF.getCode());
        }
    }

    @Test
    @Transactional
    void decreaseStock(){
        List<CartDto> cartDtos=new ArrayList<>();
        CartDto ca=new CartDto();
        ca.setProductId("0001");
        ca.setProductQuantity(50);
        cartDtos.add(ca);
        ca=new CartDto();
        ca.setProductQuantity(70);
        ca.setProductId("0003");
        cartDtos.add(ca);
        productInfoS.decreaseStock(cartDtos);
    }

    @Test
    void decreaseStock1(){
        List<CartDto> cartDtos=new ArrayList<>();
        CartDto ca=new CartDto();
        ca.setProductId("0001");
        ca.setProductQuantity(10000);
        cartDtos.add(ca);
        try {
            productInfoS.decreaseStock(cartDtos);
        } catch (productException e) {
            Assert.assertEquals(e.getMessage(), exceptionEnum.PROUDUCT_INSUFFICIENT.getMsg());
        }
    }

    @Test
    void decreaseStock2(){
        List<CartDto> cartDtos=new ArrayList<>();
        CartDto ca=new CartDto();
        ca.setProductId("0005");
        ca.setProductQuantity(10);
        cartDtos.add(ca);
        try {
            productInfoS.decreaseStock(cartDtos);
        } catch (productException e) {
            Assert.assertEquals(e.getMessage(), exceptionEnum.PRODUCT_NULL.getMsg());
        }
    }

    @Test
    void decreaseStock3(){
        List<CartDto> cartDtos=new ArrayList<>();
        CartDto ca=new CartDto();
        ca.setProductId("0002");
        ca.setProductQuantity(10);
        cartDtos.add(ca);
        try {
            productInfoS.decreaseStock(cartDtos);
        } catch (productException e) {
            Assert.assertEquals(e.getMessage(), exceptionEnum.PRODUCT_DOWN_SHELF.getMsg());
        }
    }
}
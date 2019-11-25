package com.example.produck.service.impl;

import com.example.produck.dto.CartDto;
import com.example.produck.dto.productInfoDto;
import com.example.produck.entity.productInfo;
import com.example.produck.enums.exceptionEnum;
import com.example.produck.enums.productStatusEnum;
import com.example.produck.exception.productException;
import com.example.produck.repository.productInfoRepository;
import com.example.produck.service.productInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/11/22 10:21
 * @description：
 */
@Service
public class productInfoServiceImpl implements productInfoService {

    @Autowired
    productInfoRepository productInfoR;

    @Override
    public List<productInfo> findUpAll() {
        List<productInfo> productList = productInfoR.findByProductStatus(productStatusEnum.UP_SHELF.getCode());
        return productList;
    }

    @Override
    public List<productInfoDto> finByProductIdIn(List<String> productIdList) {
        List<productInfo> productInfoList = productInfoR.findByProductIdIn(productIdList);
        List<productInfoDto> list=new ArrayList<>();
        for (productInfo info : productInfoList) {
            BeanUtils.copyProperties(info,list);
        }
        return list;
    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDto> cartDtos) {
        for (CartDto ca : cartDtos) {
            Optional<productInfo> pro = productInfoR.findById(ca.getProductId());
            Integer SurplusStock;
            if(!pro.isPresent()){   //商品不存在
                throw new productException(exceptionEnum.PRODUCT_NULL);
            }else if(pro.get().getProductStatus().equals(productStatusEnum.DOWN_SHELF)){     //商品已下架
                throw new productException(exceptionEnum.PRODUCT_DOWN_SHELF);
            }else if((SurplusStock=pro.get().getProductStock()-ca.getProductQuantity())<0){     //商品库存不足
                throw new productException(exceptionEnum.PROUDUCT_INSUFFICIENT);
            }
            //设置剩余库存
            pro.get().setProductStock(SurplusStock);
            //保存到数据库
            productInfoR.save(pro.get());
        }
    }
}

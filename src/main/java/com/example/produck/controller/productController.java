package com.example.produck.controller;

import com.example.produck.dto.CartDto;
import com.example.produck.dto.Resoult;
import com.example.produck.dto.productDto;
import com.example.produck.dto.productInfoDto;
import com.example.produck.entity.productCategory;
import com.example.produck.entity.productInfo;
import com.example.produck.service.productCategoryService;
import com.example.produck.service.productInfoService;
import com.example.produck.util.ResoultUtil;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/11/22 13:14
 * @description：
 */
@RestController
@RequestMapping("/product")
public class productController {

    @Autowired
    productInfoService productInfoS;

    @Autowired
    productCategoryService productCategoryS;

    @GetMapping("/getProductList")
    public Resoult getProductList(){
        //查询所有在架商品
        List<productInfo> proList = productInfoS.findUpAll();
        //获取所有的类目
        List<Integer> cateType=proList.stream()
                .map(productInfo::getCategoryType)
                .collect(Collectors.toList());
        //查询类目信息
        List<productCategory> cateList = productCategoryS.findByCategoryTypeIn(cateType);
        //组装数据
        List<productDto> dtoList=new ArrayList<>();
        for (productCategory category : cateList) {
            productDto dto=new productDto(category.getCategoryName(),category.getCategoryType());

            for (productInfo info : proList) {
                if(info.getCategoryType().equals(dto.getCategoryType())){
                    productInfoDto infoDto=new productInfoDto();
                    BeanUtils.copyProperties(info,infoDto);
                    dto.getProductInfoList().add(infoDto);
                }
            }
            dtoList.add(dto);
        }
        return ResoultUtil.success(dtoList);
    }

    /**
     * 根据商品ID查询商品信息
     * 订单服务调用
     * @param productIdList
     * @return
     */
    @PostMapping("/getProductById")
    public List<productInfo> getProductById(@RequestBody List<String> productIdList){
        return productInfoS.finByProductIdIn(productIdList);
    }

    /**
     * 扣除商品列表中的库存
     * @param productStock
     */
    @PostMapping("/decreaseStock")
    public Resoult decreaseStock(@RequestBody List<CartDto> productStock){
        productInfoS.decreaseStock(productStock);
        return ResoultUtil.success();
    }

}

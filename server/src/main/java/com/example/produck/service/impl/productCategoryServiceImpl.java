package com.example.produck.service.impl;

import com.example.produck.entity.productCategory;
import com.example.produck.repository.productCategoryRepository;
import com.example.produck.service.productCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/11/22 12:34
 * @description：
 */
@Service
public class productCategoryServiceImpl implements productCategoryService {

    @Autowired
    productCategoryRepository productCategoryR;

    @Override
    public List<productCategory> findByCategoryTypeIn(List<Integer> CategoryTypeList) {
        List<productCategory> cateList = productCategoryR.findByCategoryTypeIn(CategoryTypeList);
        return cateList;
    }
}

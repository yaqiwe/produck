package com.example.produck.repository;

import com.example.produck.entity.productCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/11/22 9:54
 * @description：
 */
public interface productCategoryRepository extends JpaRepository<productCategory,Integer> {

    /**
     * 根据CategoryType列表查询商品类目
     * @param CategoryTypeList
     * @return
     */
    List<productCategory> findByCategoryTypeIn(List<Integer> CategoryTypeList);
}

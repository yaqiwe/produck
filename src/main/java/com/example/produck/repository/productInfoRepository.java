package com.example.produck.repository;

import com.example.produck.entity.productInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/11/20 21:37
 * @description：
 */
@Repository
public interface productInfoRepository extends JpaRepository<productInfo,String> {

    /**
     * 按商品状态 分页 查询商品
     * @param status 商品状态
     * @return
     */
    List<productInfo> findByProductStatus(Integer status);

    /**
     * 根据商品Id列表查询商品信息
     * @param productIdList
     * @return
     */
    List<productInfo> findByProductIdIn(List<String> productIdList);
}

package com.example.produck.entity;

import lombok.Data;
import org.hibernate.type.descriptor.sql.TinyIntTypeDescriptor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/11/20 20:18
 * @description：商品表
 */
@Entity
@Data
public class productInfo {
    @Id
    private String productId;   //商品Id

    private String productName;     //商品名称

    private BigDecimal productPrice;        //商品单价

    private Integer productStock;       //商品库存

    private String productDescription;      //描述

    private String productIcon;     //小图的Url

    private Integer categoryType;       //商品类目编号

    @Column(length = 4,columnDefinition = "TINYINT")
    private Integer productStatus;      //状态，0正常1下架

    private Timestamp createTime;      //创建时间

    private Timestamp updateTime;       //更新时间
}

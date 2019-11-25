package com.example.produck.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/11/22 9:49
 * @description：商品类目表
 */
@Data
@Entity
@DynamicUpdate
@DynamicInsert
public class productCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;     //自增主键

    private String categoryName;        //类目名称

    private Integer categoryType;       //类目编号

    private Timestamp createTime;       //创建时间

    private Timestamp updateTime;       //更新时间
}

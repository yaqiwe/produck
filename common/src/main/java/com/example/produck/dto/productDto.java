package com.example.produck.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/11/22 12:59
 * @description：商品列表dto
 */
@Data
public class productDto {

    @JsonProperty("name")
    private String categoryName;       //类目名称

    @JsonProperty("type")
    private Integer categoryType;       //类目Id

    @JsonProperty("foods")
    private List<productInfoDto> productInfoList;       //该类目下的商品

    public productDto(String categoryName,Integer categoryType){
        this.categoryName=categoryName;
        this.categoryType=categoryType;
        productInfoList=new ArrayList<>();
    }

    public productDto() {
    }
}

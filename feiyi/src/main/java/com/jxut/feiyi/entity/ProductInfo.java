package com.jxut.feiyi.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ProductInfo {
    private Integer productId;

    private String productCore;

    private String productName;

    private String barCode;

    private Integer brandId;

    private Short oneCategoryId;

    private Short twoCategoryId;

    private Short threeCategoryId;

    private Integer supplierId;

    private BigDecimal price;

    private BigDecimal averageCost;

    private Byte publishStatus;

    private Byte auditStatus;

    private Float goodsWeight;

    private Float goodsLength;

    private Float goodsHeight;

    private Float goodsWidth;

    private String colorType;

    private Date productionDate;

    private Integer shelfLife;

    private String descript;

    private String pic;

    private Date indate;

    private Date modifiedTime;


}
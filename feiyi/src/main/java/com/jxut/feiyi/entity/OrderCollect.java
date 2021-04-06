package com.jxut.feiyi.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class OrderCollect {
    private Integer collectId;

    private Integer productId;

    private Integer customerId;

    private Date collectTime;

    private Integer productNumber;

    private BigDecimal price;
    private String productName;

    private String descript;

    private String pic;

}
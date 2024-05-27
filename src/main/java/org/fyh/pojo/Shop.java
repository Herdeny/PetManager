package org.fyh.pojo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Shop {
    private Integer goodsId;
    private String goodsName;
    private BigDecimal goodsPrice;
    private boolean goodsStatus;
    private Integer goodsAmount;
    private String goodsImg;
    private Integer goodsSold;
    private String goodsDesc;

}

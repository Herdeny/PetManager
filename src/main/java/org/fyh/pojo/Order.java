package org.fyh.pojo;

import lombok.Data;

@Data
public class Order {
    private Integer orderId;
    private Integer userId;
    private Integer goodsId;
    private String goodsName;
    private String goodsImg;
    private Integer amount;
    private String orderStatus;
    private String createTime;
    private String updateTime;
}

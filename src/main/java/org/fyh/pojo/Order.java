package org.fyh.pojo;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class Order {
    private Integer orderId;
    private Integer userId;
    private Integer goodsId;
    private String goodsName;
    private Integer orderValue;
    private String goodsImg;
    private Integer amount;
    private String orderStatus;
    private Date createTime;
    private Date updateTime;
    private String passCode;
}

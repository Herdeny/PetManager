package org.fyh.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class GoodsSold {
    private Integer goodsId;
    private Integer soldAmount;
    private Date soldDate;
}

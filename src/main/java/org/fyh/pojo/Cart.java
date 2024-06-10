package org.fyh.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Cart {
    private Integer id;
    private Integer userId;
    private Integer goodsId;
    private Integer goodsAmount;
    private LocalDateTime createTime;
}

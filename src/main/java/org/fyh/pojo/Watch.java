package org.fyh.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Watch {
    private Integer id;
    private Integer userId;
    private Integer goodsId;
    private Date createTime;
}

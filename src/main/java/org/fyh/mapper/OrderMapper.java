package org.fyh.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.fyh.pojo.Order;

import java.util.List;

@Mapper
public interface OrderMapper {
    @Insert("insert into `order`(user_id, goods_id, goods_name, goods_img,amount, create_time, update_time,order_status) values(#{userId}, #{goodsId},#{goodsName},#{goodsImg}, #{amount}, now(), now(),'已下单')")
    void add(int userId, int goodsId, String goodsName, String goodsImg, int amount);

    List<Order> getOrder(int user_id, String orderStatus, String goodsName);

    List<Order> getOrderOn(int userId, String orderStatus, String goodsName);

    List<Order> getOrderOff(int userId, String orderStatus, String goodsName);
}

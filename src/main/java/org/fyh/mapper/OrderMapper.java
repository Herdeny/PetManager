package org.fyh.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.fyh.pojo.Order;

import java.util.Date;
import java.util.List;

@Mapper
public interface OrderMapper {
    @Insert("insert into `order`(user_id, goods_id, goods_name, goods_img,amount, create_time, update_time,order_status,order_value) values(#{userId}, #{goodsId},#{goodsName},#{goodsImg}, #{amount}, now(), now(),'已下单',#{orderValue})")
    void add(int userId, int goodsId, String goodsName, String goodsImg, int amount, int orderValue);

    List<Order> getOrder(int user_id, String orderStatus, String goodsName);

    List<Order> getOrderAll(String orderStatus, String goodsName);

    List<Order> getOrderOn(int userId, String orderStatus, String goodsName);

    List<Order> getOrderOff(int userId, String orderStatus, String goodsName);

    @Update("update `order` set order_status = '已取消' where order_id = #{orderId}")
    void cancel(Integer orderId);

    @Select("select * from `order` where order_id = #{orderId}")
    Order get(Integer orderId);

    @Update("update `order` set order_status = '已完成' where order_id = #{orderId}")
    void claim(Integer orderId);

    @Select("select count(*) from `order` where user_id = #{userId}")
    Integer count(int userId);

    @Update("update `order` set order_status = #{orderStatus}, update_time = now() ,pass_code = #{passCode} where order_id = #{orderId}")
    void update(Order order);

    @Select("select sum(order_value) from `order` where goods_id = #{goodsId}")
    Integer getValueByGoods(Integer goodsId);

    //create_time的年月日和date的年月日一样
    @Select("select sum(order_value) from `order` where goods_id = #{goodsId} and date_format(create_time, '%Y-%m-%d') = date_format(#{date}, '%Y-%m-%d')")
    Integer getDayValueByGoods(Integer goodsId, Date date);
}

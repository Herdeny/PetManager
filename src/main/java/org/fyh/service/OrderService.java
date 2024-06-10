package org.fyh.service;

import org.fyh.pojo.Order;

import java.util.Date;
import java.util.List;

public interface OrderService {
    void add(int userId, int goodsId, int amount, int orderValue);

    List<Order> getOrder(int user_id, String orderStatus, String orderName);

    List<Order> getOrderAll(String orderStatus, String goodsName);

    List<Order> getOrderOn(int userId, String orderStatus, String goodsName);

    List<Order> getOrderOff(int userId, String orderStatus, String goodsName);

    void cancel(Integer orderId);

    Order get(Integer orderId);

    void claim(Integer orderId);

    Integer count(int userId);

    void update(Order order);

    Integer getValueByGoods(Integer goodsId);

    Integer getDayValueByGoods(Integer goodsId, Date date);
}

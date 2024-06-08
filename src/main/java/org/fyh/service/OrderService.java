package org.fyh.service;

import org.fyh.pojo.Order;

import java.util.List;

public interface OrderService {
    void add(int userId, int goodsId, int amount);

    List<Order> getOrder(int user_id, String orderStatus, String orderName);

    List<Order> getOrderOn(int userId, String orderStatus, String goodsName);

    List<Order> getOrderOff(int userId, String orderStatus, String goodsName);
}

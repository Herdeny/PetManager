package org.fyh.service.impl;

import org.fyh.mapper.OrderMapper;
import org.fyh.mapper.ShopMapper;
import org.fyh.pojo.Order;
import org.fyh.pojo.Shop;
import org.fyh.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private static final Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private ShopMapper shopMapper;


    @Override
    public void add(int userId, int goodsId, int amount,int orderValue) {
        Shop shop = shopMapper.get(goodsId);
        orderMapper.add(userId, goodsId, shop.getGoodsName(), shop.getGoodsImg(), amount,orderValue);
    }

    @Override
    public List<Order> getOrder(int user_id, String orderStatus, String orderName) {
        return orderMapper.getOrder(user_id,orderStatus, orderName);
    }

    @Override
    public List<Order> getOrderAll(String orderStatus, String goodsName) {
        return orderMapper.getOrderAll(orderStatus, goodsName);
    }

    @Override
    public List<Order> getOrderOn(int userId, String orderStatus, String goodsName) {
        return orderMapper.getOrderOn(userId,orderStatus, goodsName);
    }

    @Override
    public List<Order> getOrderOff(int userId, String orderStatus, String goodsName) {
        return orderMapper.getOrderOff(userId,orderStatus, goodsName);
    }

    @Override
    public void cancel(Integer orderId) {
        orderMapper.cancel(orderId);
    }

    @Override
    public Order get(Integer orderId) {
        return orderMapper.get(orderId);
    }

    @Override
    public void claim(Integer orderId) {
        orderMapper.claim(orderId);
    }

    @Override
    public Integer count(int userId) {
        return orderMapper.count(userId);
    }

    @Override
    public void update(Order order) {
        orderMapper.update(order);
    }

    @Override
    public Integer getValueByGoods(Integer goodsId) {
        return orderMapper.getValueByGoods(goodsId);
    }

    @Override
    public Integer getDayValueByGoods(Integer goodsId, Date date) {
        log.info("goodsId: {}, date: {}", goodsId, date);
        log.info("date: {}", new java.sql.Date(date.getTime()));
        return orderMapper.getDayValueByGoods(goodsId, new java.sql.Date(date.getTime()));
    }
}

package org.fyh.service.impl;

import org.fyh.mapper.OrderMapper;
import org.fyh.mapper.ShopMapper;
import org.fyh.pojo.Order;
import org.fyh.pojo.Shop;
import org.fyh.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private ShopMapper shopMapper;


    @Override
    public void add(int userId, int goodsId, int amount) {
        Shop shop = shopMapper.get(goodsId);
        orderMapper.add(userId, goodsId, shop.getGoodsName(), shop.getGoodsImg(), amount);
    }

    @Override
    public List<Order> getOrder(int user_id, String orderStatus, String orderName) {
        return orderMapper.getOrder(user_id,orderStatus, orderName);
    }

    @Override
    public List<Order> getOrderOn(int userId, String orderStatus, String goodsName) {
        return orderMapper.getOrderOn(userId,orderStatus, goodsName);
    }

    @Override
    public List<Order> getOrderOff(int userId, String orderStatus, String goodsName) {
        return orderMapper.getOrderOff(userId,orderStatus, goodsName);
    }
}

package org.fyh.service.impl;

import org.fyh.mapper.CartMapper;
import org.fyh.pojo.Cart;
import org.fyh.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartMapper cartMapper;

    @Override
    public List<Cart> list(int userId) {
        return cartMapper.list(userId);
    }

    @Override
    public void add(int userId, Integer goodsId, Integer amount) {
        //如果购物车中已经存在该商品，则更新数量
        Cart cart = cartMapper.get(userId, goodsId);
        if (cart != null) {
            cartMapper.update(userId, goodsId, amount);
            return;
        }
        cartMapper.add(userId, goodsId, amount);
    }

    @Override
    public void delete(int userId, Integer goodsId) {
        cartMapper.delete(userId, goodsId);
    }
}

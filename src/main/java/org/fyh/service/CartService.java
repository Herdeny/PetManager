package org.fyh.service;

import org.fyh.pojo.Cart;

import java.util.List;

public interface CartService {
    List<Cart> list(int userId);

    void add(int userId, Integer goodsId, Integer amount);

    void delete(int userId, Integer goodsId);
}

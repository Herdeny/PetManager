package org.fyh.service;

import org.fyh.pojo.PageBean;
import org.fyh.pojo.Shop;

public interface ShopService {
    PageBean<Shop> list(Integer pageNum, Integer pageSize, Boolean goodsStatus, Integer minValue, Integer maxValue, boolean onlyOnShelves);

    PageBean<Shop> hotList(Integer pageNum, Integer pageSize);

    void add(Shop shop);

    void update(Shop shop);

    void delete(Shop shop);

    void buy(int goodsId, int amount);

    Shop get(int goodsId);


}

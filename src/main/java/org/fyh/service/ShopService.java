package org.fyh.service;

import org.fyh.pojo.PageBean;
import org.fyh.pojo.Shop;

public interface ShopService {
    PageBean<Shop> list(Integer pageNum, Integer pageSize, Boolean goodsStatus);

    void add(Shop shop);

    void update(Shop shop);

    void delete(Shop shop);
}

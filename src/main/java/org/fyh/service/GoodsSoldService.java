package org.fyh.service;

import org.fyh.pojo.GoodsSold;

import java.util.Date;

public interface GoodsSoldService {
    GoodsSold get(int goodsId, Date date);

    void add(int goodsId, int amount, Date date);
}

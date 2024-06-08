package org.fyh.service.impl;

import org.fyh.mapper.GoodsSoldMapper;
import org.fyh.pojo.GoodsSold;
import org.fyh.service.GoodsSoldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Service
public class GoodsSoldServiceImpl implements GoodsSoldService {
    @Autowired
    private GoodsSoldMapper goodsSoldMapper;

    @Override
    public GoodsSold get(int goodsId, Date date) {
        return goodsSoldMapper.get(goodsId, date);
    }

    @Override
    public void add(int goodsId, int amount) {
        //创造一个 年-月-日的日期
        LocalDate currentDate = LocalDate.now();
        GoodsSold goodsSold = goodsSoldMapper.get(goodsId, java.sql.Date.valueOf(currentDate));
        if (goodsSold != null) {
            goodsSoldMapper.update(goodsId, goodsSold.getSoldAmount() + amount, java.sql.Date.valueOf(currentDate));
        }else goodsSoldMapper.add(goodsId, amount);

    }
}

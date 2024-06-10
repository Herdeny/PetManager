package org.fyh.service.impl;

import org.fyh.mapper.SoldValueMapper;
import org.fyh.pojo.SoldValue;
import org.fyh.service.SoldValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Service
public class SoldValueServiceImpl implements SoldValueService {

    @Autowired
    private SoldValueMapper soldValueMapper;

    @Override
    public SoldValue get(int userId, Date date) {
        return soldValueMapper.get(userId, date);
    }


    @Override
    public void add(int userId, int value, Date date) {
        if (date != null) {
            SoldValue soldValue = soldValueMapper.get(userId, new java.sql.Date(date.getTime()));
            if (soldValue != null) {
                soldValueMapper.update(userId, soldValue.getValue() + value, new java.sql.Date(date.getTime()));
            } else soldValueMapper.add(userId, value);
        } else {
            //创造一个 年-月-日的日期
            LocalDate currentDate = LocalDate.now();
            SoldValue soldValue = soldValueMapper.get(userId, java.sql.Date.valueOf(currentDate));
            if (soldValue != null) {
                soldValueMapper.update(userId, soldValue.getValue() + value, java.sql.Date.valueOf(currentDate));
            } else soldValueMapper.add(userId, value);
        }
    }

    @Override
    public Integer value(int userId) {
        return soldValueMapper.value(userId);
    }

    @Override
    public Integer valueAll() {
        return soldValueMapper.valueAll();
    }

    @Override
    public Integer getDay(Date date) {
        return soldValueMapper.getDay(new java.sql.Date(date.getTime()));
    }
}

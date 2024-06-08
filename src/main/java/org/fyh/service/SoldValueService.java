package org.fyh.service;

import org.fyh.pojo.SoldValue;

import java.util.Date;

public interface SoldValueService {
    SoldValue get(int userId, Date date);

    void add(int userId, int value);
}

package org.fyh.service;

import org.fyh.pojo.Watch;

import java.util.List;

public interface WatchService {

    void add(int userId, int goodsId);

    List<Watch> list(int userId);
}

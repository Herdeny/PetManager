package org.fyh.service.impl;

import org.fyh.mapper.WatchMapper;
import org.fyh.pojo.Watch;
import org.fyh.service.WatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WatchServiceImpl implements WatchService {
    @Autowired
    private WatchMapper watchMapper;


    @Override
    public void add(int userId, int goodsId) {
        Watch watch = watchMapper.get(userId, goodsId);
        if (watch != null) {
            watchMapper.update(watch.getId());
        } else watchMapper.add(userId, goodsId);
    }

    @Override
    public List<Watch> list(int userId) {
        return watchMapper.list(userId);
    }
}

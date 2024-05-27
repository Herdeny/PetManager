package org.fyh.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.fyh.mapper.ShopMapper;
import org.fyh.pojo.PageBean;
import org.fyh.pojo.Pet;
import org.fyh.pojo.Shop;
import org.fyh.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopMapper shopMapper;

    @Override
    public PageBean<Shop> list(Integer pageNum, Integer pageSize, Boolean goodsStatus) {
        PageBean<Shop> pageBean = new PageBean<>();
        PageHelper.startPage(pageNum, pageSize);
        List<Shop> petList = shopMapper.list(goodsStatus);
        Page<Shop> page = (Page<Shop>) petList;
        pageBean.setTotal(page.getTotal());
        pageBean.setItems(page.getResult());
        return pageBean;
    }

    @Override
    public void add(Shop shop) {
        shopMapper.add(shop);
    }

    @Override
    public void update(Shop shop) {
        shopMapper.update(shop);
    }

    @Override
    public void delete(Shop shop) {
        shopMapper.delete(shop);
    }
}

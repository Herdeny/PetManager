package org.fyh.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.fyh.mapper.ShopMapper;
import org.fyh.pojo.PageBean;
import org.fyh.pojo.Pet;
import org.fyh.pojo.Shop;
import org.fyh.service.ShopService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopMapper shopMapper;

    @Override
    public PageBean<Shop> list(Integer pageNum, Integer pageSize, Boolean goodsStatus, Integer minValue, Integer maxValue, boolean onlyOnShelves) {
        PageBean<Shop> pageBean = new PageBean<>();
        PageHelper.startPage(pageNum, pageSize);
        List<Shop> shopList = shopMapper.list(goodsStatus, minValue, maxValue, onlyOnShelves);
        Page<Shop> page = (Page<Shop>) shopList;
        pageBean.setTotal(page.getTotal());
        pageBean.setItems(page.getResult());
        return pageBean;
    }

    @Override
    public PageBean<Shop> hotList(Integer pageNum, Integer pageSize) {
        PageBean<Shop> pageBean = new PageBean<>();
        PageHelper.startPage(pageNum, pageSize);
        List<Shop> petList = shopMapper.hotList();
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

    @Override
    public void buy(int goodsId, int amount) {
        shopMapper.buy(goodsId, amount);
        shopMapper.updateSold(goodsId, amount);
    }

    @Override
    public Shop get(int goodsId) {
        return shopMapper.get(goodsId);
    }

    @Override
    public void star(int userId, Integer goodsId) {
        shopMapper.star(userId, goodsId);
    }

    @Override
    public void unstar(int userId, Integer goodsId) {
        shopMapper.unstar(userId, goodsId);
    }

    @Override
    public List<Shop> starList(int userId) {
        return shopMapper.starList(userId);
    }

    @Override
    public boolean isStar(int userId, Integer goodsId) {
        return shopMapper.isStar(userId, goodsId) > 0;
    }

    @Override
    public List<Shop> hotListArray() {
        return shopMapper.hotList();
    }

    @Override
    public List<Shop> listArray() {
        return shopMapper.listArray();
    }

}

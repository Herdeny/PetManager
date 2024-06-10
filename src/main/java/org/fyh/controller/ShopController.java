package org.fyh.controller;

import lombok.Data;
import org.fyh.pojo.PageBean;
import org.fyh.pojo.Result;
import org.fyh.pojo.Shop;
import org.fyh.service.GoodsSoldService;
import org.fyh.service.OrderService;
import org.fyh.service.ShopService;
import org.fyh.utils.ThreadLocalUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/shop")
public class ShopController {
    private static final Logger log = LoggerFactory.getLogger(ShopController.class);
    @Autowired
    private ShopService ShopService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private GoodsSoldService goodsSoldService;

    @GetMapping
    public Result<PageBean<Shop>> list(
            Integer pageNum,
            Integer pageSize,
            @RequestParam(required = false) Boolean goodsStatus,
            @RequestParam(required = false) Integer minValue,
            @RequestParam(required = false) Integer maxValue,
            @RequestParam(required = false) boolean onlyOnShelves
    ) {
        PageBean<Shop> pageBean = ShopService.list(pageNum, pageSize, goodsStatus, minValue, maxValue, onlyOnShelves);
        return Result.success(pageBean);
    }

    @GetMapping("/list/all")
    public List<Shop> list() {
        return ShopService.listArray();
    }

    @GetMapping("/onShelves")
    public Result<PageBean<Shop>> onShelves(
            Integer pageNum,
            Integer pageSize,
            Integer minValue,
            Integer maxValue,
            boolean onlyOnShelves
    ) {
        return list(pageNum, pageSize, true, minValue, maxValue, onlyOnShelves);
    }

    @GetMapping("/hotList")
    public Result<PageBean<Shop>> hotList(
            Integer pageNum,
            Integer pageSize
    ) {
        PageBean<Shop> pageBean = ShopService.hotList(pageNum, pageSize);
        return Result.success(pageBean);
    }
@GetMapping("/hotList/list")
    public List<Shop> hotList() {
        return ShopService.hotListArray();
    }
    @GetMapping("/get")
    public Shop get(int goodsId) {
        return ShopService.get(goodsId);
    }

    @PostMapping("/add")
    public Result add(@RequestBody Shop shop) {
        ShopService.add(shop);
        return Result.success(shop);
    }

    @PostMapping("/update")
    public Result update(@RequestBody Shop shop) {
        ShopService.update(shop);
        return Result.success(shop);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Shop shop) {
        ShopService.delete(shop);
        return Result.success(shop);
    }

    @PostMapping("/buy")
    public Result buy(
            @RequestParam(value = "goodsId") Integer goodsId,
            @RequestParam(value = "amount") Integer amount,
            @RequestParam(required = false) Date date,
            @RequestParam(value = "orderValue") Integer orderValue)
    {
        Shop shop = get(goodsId);
        if (shop == null) {
            return Result.error(205, "商品不存在");
        } else if (shop.getGoodsAmount() < amount) {
            return Result.error(205, "库存不足");
        } else if (!shop.isGoodsStatus()) {
            return Result.error(205, "商品已下架");
        } else {
            ShopService.buy(goodsId, amount);
            Map<String, Object> claims = ThreadLocalUtil.get();
            int userId = (int) claims.get("id");
            orderService.add(userId, goodsId, amount, orderValue);
            goodsSoldService.add(goodsId, amount, date);
            return Result.success();
        }
    }

    @PostMapping("/star")
    public Result star(@RequestParam(value = "goodsId") Integer goodsId) {
        Map<String, Object> claims = ThreadLocalUtil.get();
        int userId = (int) claims.get("id");
        ShopService.star(userId, goodsId);
        return Result.success();
    }

    @PostMapping("/unStar")
    public Result unstar(@RequestParam(value = "goodsId") Integer goodsId) {
        Map<String, Object> claims = ThreadLocalUtil.get();
        int userId = (int) claims.get("id");
        ShopService.unstar(userId, goodsId);
        return Result.success();
    }

    @GetMapping("/starList")
    public Result<List<Shop>> starList() {
        Map<String, Object> claims = ThreadLocalUtil.get();
        int userId = (int) claims.get("id");
        List<Shop> petList = ShopService.starList(userId);
        return Result.success(petList);
    }

    @GetMapping("/isStar")
    public Result<Boolean> isStar(@RequestParam(value = "goodsId") Integer goodsId) {
        Map<String, Object> claims = ThreadLocalUtil.get();
        int userId = (int) claims.get("id");
        boolean isStar = ShopService.isStar(userId, goodsId);
        return Result.success(isStar);
    }
}

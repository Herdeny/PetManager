package org.fyh.controller;

import org.fyh.pojo.PageBean;
import org.fyh.pojo.Pet;
import org.fyh.pojo.Result;
import org.fyh.pojo.Shop;
import org.fyh.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shop")
public class ShopController {
    @Autowired
    private ShopService ShopService;

    @GetMapping
    public Result<PageBean<Shop>> list(
            Integer pageNum,
            Integer pageSize,
            @RequestParam(required = false) Boolean goodsStatus
    ) {
        PageBean<Shop> pageBean = ShopService.list(pageNum, pageSize, goodsStatus);
        return Result.success(pageBean);
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
}

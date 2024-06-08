package org.fyh.controller;

import org.fyh.pojo.Order;
import org.fyh.pojo.Result;
import org.fyh.pojo.User;
import org.fyh.service.OrderService;
import org.fyh.utils.ThreadLocalUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {

    private static final Logger log = LoggerFactory.getLogger(OrderController.class);
    @Autowired
    private OrderService orderService;

    @GetMapping("/all")
    public Result<List<Order>> getOrderAll(@RequestParam(required = false) String orderStatus , @RequestParam(required = false) String goodsName) {
        Map<String, Object> claims = ThreadLocalUtil.get();
        int user_id = (int) claims.get("id");
        if (goodsName != null) {
            goodsName = "%" + goodsName + "%";
        }
        return Result.success(orderService.getOrder(user_id,orderStatus, goodsName));
    }

    @GetMapping("/on")
    public Result<List<Order>> getOrderOn(@RequestParam(required = false) String orderStatus , @RequestParam(required = false) String goodsName) {
        Map<String, Object> claims = ThreadLocalUtil.get();
        int user_id = (int) claims.get("id");
        if (goodsName != null) {
            goodsName = "%" + goodsName + "%";
        }
        return Result.success(orderService.getOrderOn(user_id,orderStatus, goodsName));
    }
    @GetMapping("/off")
    public Result<List<Order>> getOrderOff(@RequestParam(required = false) String orderStatus , @RequestParam(required = false) String goodsName) {
        Map<String, Object> claims = ThreadLocalUtil.get();
        int user_id = (int) claims.get("id");
        if (goodsName != null) {
            goodsName = "%" + goodsName + "%";
        }
        return Result.success(orderService.getOrderOff(user_id,orderStatus, goodsName));
    }
}

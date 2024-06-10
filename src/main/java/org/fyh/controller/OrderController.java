package org.fyh.controller;

import org.fyh.pojo.*;
import org.fyh.service.GoodsSoldService;
import org.fyh.service.OrderService;
import org.fyh.service.ShopService;
import org.fyh.service.SoldValueService;
import org.fyh.utils.ThreadLocalUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/order")
public class OrderController {

    private static final Logger log = LoggerFactory.getLogger(OrderController.class);
    @Autowired
    private OrderService orderService;
    @Autowired
    private ShopService shopService;
    @Autowired
    private GoodsSoldService goodsSoldService;
    @Autowired
    private SoldValueService soldValueService;

    @GetMapping("/all")
    public Result<List<Order>> getOrderAll(@RequestParam(required = false) String orderStatus, @RequestParam(required = false) String goodsName) {
        Map<String, Object> claims = ThreadLocalUtil.get();
        int user_id = (int) claims.get("id");
        if (goodsName != null) {
            goodsName = "%" + goodsName + "%";
        }
        return Result.success(orderService.getOrder(user_id, orderStatus, goodsName));
    }

    @GetMapping("/allUser")
    public Result<List<Order>> getOrderAllUser(@RequestParam(required = false) String orderStatus, @RequestParam(required = false) String goodsName) {
        Map<String, Object> claims = ThreadLocalUtil.get();
        if (goodsName != null) {
            goodsName = "%" + goodsName + "%";
        }
        return Result.success(orderService.getOrderAll(orderStatus, goodsName));
    }

    @GetMapping("/on")
    public Result<List<Order>> getOrderOn(@RequestParam(required = false) String orderStatus, @RequestParam(required = false) String goodsName) {
        Map<String, Object> claims = ThreadLocalUtil.get();
        int user_id = (int) claims.get("id");
        if (goodsName != null) {
            goodsName = "%" + goodsName + "%";
        }
        return Result.success(orderService.getOrderOn(user_id, orderStatus, goodsName));
    }

    @GetMapping("/off")
    public Result<List<Order>> getOrderOff(@RequestParam(required = false) String orderStatus, @RequestParam(required = false) String goodsName) {
        Map<String, Object> claims = ThreadLocalUtil.get();
        int user_id = (int) claims.get("id");
        if (goodsName != null) {
            goodsName = "%" + goodsName + "%";
        }
        return Result.success(orderService.getOrderOff(user_id, orderStatus, goodsName));
    }

    @GetMapping("/get")
    public Order get(@RequestParam(value = "orderId") Integer orderId) {
        return orderService.get(orderId);
    }

    @PostMapping("/cancel")
    public Result cancel(@RequestParam(value = "orderId") Integer orderId) {
        Order order = orderService.get(orderId);
        int user_id = order.getUserId();
        Shop shop = shopService.get(order.getGoodsId());
        shopService.buy(order.getGoodsId(), -order.getAmount());
        orderService.cancel(orderId);
        goodsSoldService.add(order.getGoodsId(), -order.getAmount(), order.getCreateTime());
        soldValueService.add(user_id, -shop.getGoodsPrice().intValue() * order.getAmount(), order.getCreateTime());
        return Result.success();
    }

    @PostMapping("/claim")
    public Result claim(@RequestParam(value = "orderId") Integer orderId) {
        orderService.claim(orderId);
        return Result.success();
    }

    @GetMapping("/count")
    public Result<Integer> count() {
        Map<String, Object> claims = ThreadLocalUtil.get();
        int user_id = (int) claims.get("id");
        return Result.success(orderService.count(user_id));
    }

    @GetMapping("/value")
    public Result<Integer> value() {
        Map<String, Object> claims = ThreadLocalUtil.get();
        int user_id = (int) claims.get("id");
        return Result.success(soldValueService.value(user_id));
    }

    @GetMapping("/value/all")
    public Result<Integer> valueAll() {
        return Result.success(soldValueService.valueAll());
    }

    @PostMapping("/status")
    public Result status(@RequestParam(value = "orderId") Integer orderId, @RequestParam(value = "status") String orderStatus, @RequestParam(required = false) String pass_code) {
        Order order = orderService.get(orderId);
        order.setOrderStatus(orderStatus);
        if (Objects.equals(orderStatus, "已下单")) {
            order.setPassCode(null);
        } else if (Objects.equals(orderStatus, "已发货") && pass_code != null) {
            order.setPassCode(pass_code);
        } else log.info("已发货但运单号为空");
        orderService.update(order);
        return Result.success();
    }

    @GetMapping("/getValueByGoods")
    public Result<Integer> getValueByGoods(@RequestParam(value = "goodsId") Integer goodsId) {
        return Result.success(orderService.getValueByGoods(goodsId));
    }

    @GetMapping("/getDayValueByGoods")
    public Result<Integer> getDayValueByGoods(@RequestParam(value = "goodsId") Integer goodsId, @RequestParam(value = "date") Date date) {
        log.info("goodsId: " + goodsId + " date: " + date);
        Integer res = orderService.getDayValueByGoods(goodsId, date);
        log.info("res: " + res);
        return Result.success(orderService.getDayValueByGoods(goodsId, date));
    }
}

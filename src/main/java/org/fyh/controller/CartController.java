package org.fyh.controller;

import org.fyh.pojo.Cart;
import org.fyh.pojo.Result;
import org.fyh.service.CartService;
import org.fyh.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping("/list")
    public Result<List<Cart>> list() {
        Map<String, Object> claims = ThreadLocalUtil.get();
        int user_id = (int) claims.get("id");
        return Result.success(cartService.list(user_id));
    }

    @PostMapping("/add")
    public Result add(@RequestParam(value = "goodsId") Integer goodsId, @RequestParam(value = "amount") Integer amount) {
        Map<String, Object> claims = ThreadLocalUtil.get();
        int user_id = (int) claims.get("id");
        cartService.add(user_id, goodsId, amount);
        return Result.success();
    }

    @PostMapping("/remove")
    public Result delete(@RequestParam(value = "goodsId") Integer goodsId) {
        Map<String, Object> claims = ThreadLocalUtil.get();
        int user_id = (int) claims.get("id");
        cartService.delete(user_id, goodsId);
        return Result.success();
    }

}

package org.fyh.controller;

import org.fyh.pojo.Result;
import org.fyh.pojo.Watch;
import org.fyh.service.WatchService;
import org.fyh.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/watch")
public class WatchController {
    @Autowired
    private WatchService watchService;

    @PostMapping("/add")
    public Result add(int goodsId) {
        Map<String, Object> claims = ThreadLocalUtil.get();
        int userId = (int) claims.get("id");
        watchService.add(userId, goodsId);
        return Result.success();
    }

    @GetMapping("/list")
    public Result<List<Watch>> list() {
        Map<String, Object> claims = ThreadLocalUtil.get();
        int userId = (int) claims.get("id");
        return Result.success(watchService.list(userId));
    }

}

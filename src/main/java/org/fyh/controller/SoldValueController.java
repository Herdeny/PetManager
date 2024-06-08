package org.fyh.controller;

import org.fyh.pojo.Result;
import org.fyh.pojo.User;
import org.fyh.service.SoldValueService;
import org.fyh.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/sold")
public class SoldValueController {
    @Autowired
    private SoldValueService soldValueService;

    @PostMapping
    public Result add(@RequestParam(value = "value") Integer value) {
        Map<String, Object> claims = ThreadLocalUtil.get();
        int userId = (int) claims.get("id");
        if (userId == 0) {
            return Result.error(202);
        }
        soldValueService.add(userId, value);
        return Result.success();
    }
}

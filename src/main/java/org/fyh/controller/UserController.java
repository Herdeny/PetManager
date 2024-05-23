package org.fyh.controller;

import jakarta.validation.constraints.Pattern;
import org.fyh.pojo.Result;
import org.fyh.pojo.User;
import org.fyh.service.UserService;
import org.fyh.utils.Md5Util;
import org.fyh.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    //注册
    @PostMapping("/register")
    public Result register(@Pattern(regexp = "^[a-zA-Z0-9_]{5,16}$") String username, @Pattern(regexp = "^[a-zA-Z0-9_]{5,16}$") String password) {

        //查询用户
        User u = userService.findByUserName(username);
        if (u == null) {
            //未占用，返回为空
            userService.register(username, password); //注册
            return Result.success(); //返回结果
        } else return Result.error("username is exist");
    }

    //登录
    @PostMapping("/login")
    public Result login(@Pattern(regexp = "^[a-zA-Z0-9_]{5,16}$") String username, @Pattern(regexp = "^[a-zA-Z0-9_]{5,16}$") String password) {

        //查询用户
        User u = userService.findByUserName(username);
        if (u == null) {
            //未占用，返回为空
            return Result.error("username is not exist");
        } else {
            //已占用，返回用户
            if (u.getPassword().equals(Md5Util.getMD5String(password))) {
                //密码正确
                //生成jwt token
                Map<String, Object> claims = new HashMap<>();
                claims.put("id", u.getId());
                claims.put("username", u.getUsername());
                String jwtToken = JwtUtil.genToken(claims);
                return Result.success(jwtToken);
            } else {
                //密码错误
                return Result.error("password is error");
            }
        }
    }
    //获取用户信息
    @GetMapping("/userInfo")
    public Result<User> userInfo(@RequestHeader(name = "Authorization") String token) {
        Map<String, Object> map = JwtUtil.parseToken(token);
        Object username = map.get("username");
        User user = userService.findByUserName(username.toString());
        return Result.success(user);
    }

}

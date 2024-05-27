package org.fyh.controller;

import jakarta.validation.constraints.Pattern;
import org.fyh.pojo.PageBean;
import org.fyh.pojo.Pet;
import org.fyh.pojo.Result;
import org.fyh.pojo.User;
import org.fyh.service.UserService;
import org.fyh.utils.Md5Util;
import org.fyh.utils.JwtUtil;
import org.fyh.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
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
        System.out.println(username);
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
        System.out.println(username);
        //查询用户
        User u = userService.findByUserName(username);
        if (u == null) {
            //未占用，返回为空
            return Result.error("用户不存在");
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
                return Result.error("密码错误");
            }
        }
    }

    //获取用户信息
    @GetMapping("/userInfo")
    public Result<User> userInfo() {
        Map<String, Object> claims = ThreadLocalUtil.get();
        String username = (String) claims.get("username");
        User user = userService.findByUserName(username);
        return Result.success(user);
    }

    @PutMapping("/update")
    public Result update(@RequestBody User user) {
        if (user.getPassword() != null)
            user.setPassword(Md5Util.getMD5String(user.getPassword()));
        ;
        userService.update(user);
        return Result.success(user);
    }

    @PutMapping("/updateAvatar")
    public Result updateAvatar(@RequestParam(value = "avatarUrl") String avatarUrl) {
        Map<String, Object> claims = ThreadLocalUtil.get();
        String username = (String) claims.get("username");
        User user = userService.findByUserName(username);
        System.out.println(user);
        userService.updateAvatar(user, avatarUrl);
        return Result.success(user);
    }

    @GetMapping("/userbyid")
    public Result<User> findByUserId(Integer id) {
        User user = userService.findByUserId(id);
        return Result.success(user);
    }

    @GetMapping("/allPage")
    public Result<PageBean<User>> list(
            Integer pageNum,
            Integer pageSize
    ) {
        PageBean<User> pageBean = userService.list(pageNum, pageSize);
        return Result.success(pageBean);
    }

    @GetMapping("/all")
    public Result<List<User>> listall() {
        return Result.success(userService.listall());
    }

    @GetMapping("/idbyname")
    public Result<User> findIdByName(String username) {
        return Result.success(userService.findByUserName(username));
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestParam(value = "id") Integer id) {
        System.out.println(id);
        userService.delete(id);
        return Result.success();
    }
}

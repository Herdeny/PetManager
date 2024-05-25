package org.fyh.service;

import org.fyh.pojo.User;

public interface UserService {
    //查询用户
    User findByUserName(String username);
    //注册
    void register(String username, String password);
    //更新
    void update(User user);
}

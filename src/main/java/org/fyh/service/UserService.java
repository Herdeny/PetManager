package org.fyh.service;

import org.fyh.pojo.PageBean;
import org.fyh.pojo.Pet;
import org.fyh.pojo.User;

import java.util.List;

public interface UserService {
    //查询用户
    User findByUserName(String username);
    User findByUserId(int id);
    //注册
    void register(String username, String password);
    //更新
    void update(User user);

    List<User> findAll();

    PageBean<User> list(Integer pageNum, Integer pageSize);

    void delete(Integer id);

    List<User> listall();

    void updateAvatar(User user, String avatar);
}

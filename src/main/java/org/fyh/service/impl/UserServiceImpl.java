package org.fyh.service.impl;

import org.fyh.mapper.UserMapper;
import org.fyh.pojo.User;
import org.fyh.service.UserService;
import org.fyh.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public User findByUserName(String username) {
        User u = userMapper.findByUserName(username);
        return u;
    }

    @Override
    public void register(String username, String password) {
        //密码加密处理
        String md5Password = Md5Util.getMD5String(password);
        //数据库新增
        userMapper.add(username,md5Password);
    }
}

package org.fyh.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.fyh.mapper.UserMapper;
import org.fyh.pojo.PageBean;
import org.fyh.pojo.Pet;
import org.fyh.pojo.User;
import org.fyh.service.UserService;
import org.fyh.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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
    public User findByUserId(int id) {
        User u = userMapper.findByUserId(id);
        return u;
    }

    @Override
    public void register(String username, String password) {
        //密码加密处理
        String md5Password = Md5Util.getMD5String(password);
        //数据库新增
        userMapper.add(username,md5Password);
    }

    @Override
    public void update(User user){
        user.setUpdateTime(LocalDateTime.now());
        userMapper.update(user);
    }

    @Override
    public List<User> findAll() {
        List<User> users = userMapper.findAll();
        return users;

    }

    @Override
    public PageBean<User> list(Integer pageNum, Integer pageSize) {
        {
            PageBean<User> pageBean = new PageBean<>();
            PageHelper.startPage(pageNum, pageSize);
            List<User> userList = userMapper.findAll();
            Page<User> page = (Page<User>) userList;
            pageBean.setTotal(page.getTotal());
            pageBean.setItems(page.getResult());
            return pageBean;
        }
    }

    @Override
    public void delete(Integer id) {
        userMapper.delete(id);
    }

    @Override
    public List<User> listall() {
        return userMapper.findAll();
    }

    @Override
    public void updateAvatar(User user, String avatar) {
        userMapper.updateAvatar(user,avatar);
    }
}

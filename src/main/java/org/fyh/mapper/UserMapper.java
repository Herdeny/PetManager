package org.fyh.mapper;

import org.apache.ibatis.annotations.*;
import org.fyh.pojo.User;

import java.util.List;

@Mapper
public interface UserMapper {
    //根据用户名查询用户
    @Select("select * from user where username = #{username}")
    User findByUserName(String username);
    //根据id查询用户
    @Select("select * from user where id = #{id}")
    User findByUserId(int id);
    //添加用户
    @Insert("insert into user(username,password,create_time,update_time) values(#{username},#{password},now(),now())")
    void add(String username, String password);

    void update(User user);

    @Select("select * from user")
    List<User> findAll();
    @Delete("delete from user where id = #{id}")
    void delete(Integer id);
    @Update("update user set avatarUrl = #{avatar} where id = #{user.id}")
    void updateAvatar(User user, String avatar);
}

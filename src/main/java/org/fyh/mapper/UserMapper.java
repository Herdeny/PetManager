package org.fyh.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.fyh.pojo.User;

@Mapper
public interface UserMapper {
    //根据用户名查询用户
    @Select("select * from user where username = #{username}")
    public User findByUserName(String username);

    //添加用户
    @Insert("insert into user(username,password,createTime,updateTime) values(#{username},#{password},now(),now())")
    public void add(String username, String password);
}

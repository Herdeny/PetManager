package org.fyh.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.fyh.pojo.Watch;

import java.util.List;

@Mapper
public interface WatchMapper {
    @Select("select * from watch where user_id = #{userId} and goods_id = #{goodsId}")
    Watch get(int userId, int goodsId);

    @Update("update watch set create_time = now() where id = #{id}")
    void update(Integer id);

    @Insert("insert into watch(user_id, goods_id, create_time) values(#{userId}, #{goodsId}, now())")
    void add(int userId, int goodsId);

    @Select("select * from watch where user_id = #{userId} order by create_time desc")
    List<Watch> list(int userId);
}

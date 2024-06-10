package org.fyh.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.fyh.pojo.SoldValue;

import java.util.Date;

@Mapper
public interface SoldValueMapper {

    @Insert("insert into sold_value(user_id, value,date) values(#{userId}, #{value},now())")
    void add(int userId, int value);

    @Select("select * from sold_value where user_id = #{userId} and date = #{date}")
    SoldValue get(int userId, Date date);

    @Update("update sold_value set value = #{value} where user_id = #{userId} and date = #{date}")
    void update(int userId, int value , Date date);

    @Select("select sum(value) from sold_value where user_id = #{userId}")
    Integer value(int userId);

    @Select("select sum(value) from sold_value")
    Integer valueAll();

    @Select("select sum(value) from sold_value where date = #{date}")
    Integer getDay(java.sql.Date date);
}

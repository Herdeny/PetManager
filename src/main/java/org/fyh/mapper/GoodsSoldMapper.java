package org.fyh.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.fyh.pojo.GoodsSold;

import java.util.Date;

@Mapper
public interface GoodsSoldMapper {
    @Insert("insert into goods_sold(goods_id, sold_amount, sold_date) values(#{goodsId}, #{amount}, now())")
    void add(int goodsId, int amount);

    @Select("select * from goods_sold where goods_id = #{goodsId} and sold_date = #{date}")
    GoodsSold get(int goodsId, Date date);

    @Update("update goods_sold set sold_amount = #{amount} where goods_id = #{goodsId} and sold_date = #{date}")
    void update(int goodsId, int amount , Date date);
}

package org.fyh.mapper;

import org.apache.ibatis.annotations.*;
import org.fyh.pojo.Shop;

import java.util.List;

@Mapper
public interface ShopMapper {
    List<Shop> list(Boolean goodsStatus, Integer minValue, Integer maxValue, boolean onlyOnShelves);

    @Select("select * from shop where goods_status = 1 order by goods_sold desc")
    List<Shop> hotList();

    void add(Shop shop);

    void update(Shop shop);

    @Delete("delete from shop where goods_id = #{goodsId}")
    void delete(Shop shop);

    @Update("update shop set goods_amount = goods_amount - #{amount} where goods_id = #{goodsId}")
    void buy(int goodsId, int amount);

    @Select("select * from shop where goods_id = #{goodsId}")
    Shop get(int goodsId);

    @Update("update shop set goods_sold = goods_sold + #{amount} where goods_id = #{goodsId}")
    void updateSold(int goodsId, int amount);

    @Insert("insert into star(user_id, goods_id) values(#{userId}, #{goodsId})")
    void star(int userId, Integer goodsId);

    @Delete("delete from star where user_id = #{userId} and goods_id = #{goodsId}")
    void unstar(int userId, Integer goodsId);

    @Select("select * from shop where goods_id in (select goods_id from star where user_id = #{userId})")
    List<Shop> starList(int userId);

    @Select("select count(*) from star where user_id = #{userId} and goods_id = #{goodsId}")
    int isStar(int userId, Integer goodsId);

    @Select("select * from shop order by goods_sold desc")
    List<Shop> listArray();
}

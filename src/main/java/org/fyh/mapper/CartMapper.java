package org.fyh.mapper;

import org.apache.ibatis.annotations.*;
import org.fyh.pojo.Cart;

import java.util.List;

@Mapper
public interface CartMapper {

    @Select("select * from cart where user_id = #{userId}")
    List<Cart> list(int userId);

    @Insert("insert into cart (user_id, goods_id, goods_amount) values (#{userId}, #{goodsId}, #{amount})")
    void add(int userId, Integer goodsId, Integer amount);

    @Delete("delete from cart where user_id = #{userId} and goods_id = #{goodsId}")
    void delete(int userId, Integer goodsId);

    @Update("update cart set goods_amount = goods_amount + #{amount} where user_id = #{userId} and goods_id = #{goodsId}")
    void update(int userId, Integer goodsId, Integer amount);

    @Select("select * from cart where user_id = #{userId} and goods_id = #{goodsId}")
    Cart get(int userId, Integer goodsId);
}

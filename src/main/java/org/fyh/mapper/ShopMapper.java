package org.fyh.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
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


}

package org.fyh.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.fyh.pojo.Shop;

import java.util.List;

@Mapper
public interface ShopMapper {
    List<Shop> list(Boolean goodsStatus);

    void add(Shop shop);

    void update(Shop shop);
    @Delete("delete from shop where goods_id = #{goodsId}")
    void delete(Shop shop);
}

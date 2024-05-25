package org.fyh.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.fyh.pojo.PetCategory;

import java.util.List;
@Mapper
public interface PetCategoryMapper {
    @Select("select * from pet_category")
    List<PetCategory> list();
}

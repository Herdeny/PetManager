package org.fyh.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.fyh.pojo.PetCategory;

import java.util.List;
@Mapper
public interface PetCategoryMapper {
    @Select("select * from pet_category")
    List<PetCategory> list();
    @Select("select * from pet_category where id=#{id}")
    PetCategory get(Integer id);

    void addPetCategory(PetCategory petCategory);

    void updatePetCategory(PetCategory petCategory);
    @Delete("delete from pet_category where id=#{id}")
    void deletePetCategory(Integer id);

    @Select("select category_name from pet_category where id=#{id}")
    String getName(Integer id);
}

package org.fyh.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.fyh.pojo.PetCategoryChild;

import java.util.List;

@Mapper
public interface PetCategoryChildMapper {
    @Select("select * from pet_category_child where category_father = #{id}")
    List<PetCategoryChild> findByFatherId(int id);
    @Select("select * from pet_category_child")
    List<PetCategoryChild> findAll(Integer id);
    List<PetCategoryChild> list(String category);

    void add(PetCategoryChild petCategoryChild);

    void update(PetCategoryChild petCategoryChild);
    @Delete("delete from pet_category_child where id = #{id}")
    void delete(Integer id);
}

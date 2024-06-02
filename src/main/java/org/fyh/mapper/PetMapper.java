package org.fyh.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.fyh.pojo.Pet;

import java.util.List;

@Mapper
public interface PetMapper {

    void addPet(Pet pet);

    List<Pet> list(String category, Boolean owned, Integer ownerId);

    @Select("select * from pet where id = #{id}")
    Pet get(Integer id);

    void updatePet(Pet pet);

    @Delete("delete from pet where id = #{id}")
    void deletePet(Integer id);
    @Delete("delete from pet where owner_id = #{id}")
    void deletePetByUser(Integer id);
}

package org.fyh.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.fyh.pojo.Pet;

import java.util.List;

@Mapper
public interface PetMapper {
    @Insert("insert into pet(name,gender,birth,weight,weight,breed_times,category,is_owned,owner_id,is_sterilizated) values(#{name},#{gender},#{birth},#{weight},#{weight},#{breedTimes},#{category},#{isOwned},#{ownerId},#{isSterilizated})")
    void addPet(Pet pet);


    List<Pet> list(String category, Boolean isOwned);

}

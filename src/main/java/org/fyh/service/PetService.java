package org.fyh.service;

import org.fyh.pojo.PageBean;
import org.fyh.pojo.Pet;

import java.util.List;

public interface PetService {

    void addPet(Pet pet);

    //条件分页列表查询
    PageBean<Pet> list(Integer pageNum, Integer pageSize, String category, Boolean isOwned, Integer ownerId);

    Pet get(Integer id);

    void updatePet(Pet pet);

    void deletePet(Integer id);

    void deletePetByUser(Integer id);
}

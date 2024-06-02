package org.fyh.service;

import org.fyh.pojo.PetCategory;

import java.util.List;

public interface PetCategoryService {
    List<PetCategory> list();

    PetCategory get(Integer id);

    void addPetCategory(PetCategory petCategory);

    void updatePetCategory(PetCategory petCategory);

    void deletePetCategory(Integer id);

    String getName(Integer id);
}

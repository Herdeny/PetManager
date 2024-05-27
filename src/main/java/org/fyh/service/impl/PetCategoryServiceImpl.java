package org.fyh.service.impl;

import org.fyh.mapper.PetCategoryMapper;
import org.fyh.pojo.PetCategory;
import org.fyh.service.PetCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetCategoryServiceImpl implements PetCategoryService {

    @Autowired
    PetCategoryMapper petCategoryMapper;
    @Override
    public List<PetCategory> list() {
        return petCategoryMapper.list();
    }

    @Override
    public PetCategory get(Integer id) {
        return petCategoryMapper.get(id);
    }

    @Override
    public void addPetCategory(PetCategory petCategory) {
        petCategoryMapper.addPetCategory(petCategory);
    }

    @Override
    public void updatePetCategory(PetCategory petCategory) {
        petCategoryMapper.updatePetCategory(petCategory);
    }

    @Override
    public void deletePetCategory(Integer id) {
        petCategoryMapper.deletePetCategory(id);
    }
}

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
}

package org.fyh.service;

import org.fyh.pojo.PageBean;
import org.fyh.pojo.Pet;
import org.fyh.pojo.PetCategory;
import org.fyh.pojo.PetCategoryChild;

import java.util.List;

public interface PetCategoryChildService {
    List<PetCategoryChild> findByFatherId(int id);

    List<PetCategoryChild> findAll(Integer id);

    PageBean<PetCategoryChild> list(Integer pageNum, Integer pageSize, String category);

    void add(PetCategoryChild petCategoryChild);

    void update(PetCategoryChild petCategoryChild);

    void delete(Integer id);
}

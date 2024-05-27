package org.fyh.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.fyh.mapper.PetCategoryChildMapper;
import org.fyh.mapper.PetCategoryMapper;
import org.fyh.pojo.PageBean;
import org.fyh.pojo.Pet;
import org.fyh.pojo.PetCategory;
import org.fyh.pojo.PetCategoryChild;
import org.fyh.service.PetCategoryChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetCategoryChildServiceImpl implements PetCategoryChildService {
    @Autowired
    private PetCategoryChildMapper petCategoryChildMapper;
    @Override
    public List<PetCategoryChild> findByFatherId(int id) {
        return petCategoryChildMapper.findByFatherId(id);
    }

    @Override
    public List<PetCategoryChild> findAll(Integer id) {
        return petCategoryChildMapper.findAll(id);
    }

    @Override
    public PageBean<PetCategoryChild> list(Integer pageNum, Integer pageSize, String category) {
        PageBean<PetCategoryChild> pageBean = new PageBean<>();
        PageHelper.startPage(pageNum, pageSize);
        List<PetCategoryChild> petList = petCategoryChildMapper.list(category);
        Page<PetCategoryChild> page = (Page<PetCategoryChild>) petList;
        pageBean.setTotal(page.getTotal());
        pageBean.setItems(page.getResult());
        return pageBean;
    }

    @Override
    public void add(PetCategoryChild petCategoryChild) {
        petCategoryChildMapper.add(petCategoryChild);
    }

    @Override
    public void update(PetCategoryChild petCategoryChild) {
        petCategoryChildMapper.update(petCategoryChild);
    }

    @Override
    public void delete(Integer id) {
        petCategoryChildMapper.delete(id);
    }
}

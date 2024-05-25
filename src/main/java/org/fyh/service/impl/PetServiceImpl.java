package org.fyh.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.fyh.mapper.PetMapper;
import org.fyh.pojo.PageBean;
import org.fyh.pojo.Pet;
import org.fyh.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetServiceImpl implements PetService {

    @Autowired
    private PetMapper petMapper;

    @Override
    public void addPet(Pet pet) {
        petMapper.addPet(pet);
    }

    @Override
    public PageBean<Pet> list(Integer pageNum, Integer pageSize, String category, Boolean isOwned) {
        PageBean<Pet> pageBean = new PageBean<>();
        PageHelper.startPage(pageNum, pageSize);
        List<Pet> petList = petMapper.list(category, isOwned);
        Page<Pet> page = (Page<Pet>) petList;
        pageBean.setTotal(page.getTotal());
        pageBean.setItems(page.getResult());
        return pageBean;
    }
}

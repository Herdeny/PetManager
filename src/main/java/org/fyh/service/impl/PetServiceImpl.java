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
    public PageBean<Pet> list(Integer pageNum, Integer pageSize, String category, Boolean isOwned, Integer ownerId) {
        PageBean<Pet> pageBean = new PageBean<>();
        PageHelper.startPage(pageNum, pageSize);
        List<Pet> petList = petMapper.list(category, isOwned, ownerId);
        Page<Pet> page = (Page<Pet>) petList;
        pageBean.setTotal(page.getTotal());
        pageBean.setItems(page.getResult());
        return pageBean;
    }

    @Override
    public Pet get(Integer id) {
        return petMapper.get(id);
    }

    @Override
    public void updatePet(Pet pet) {
        petMapper.updatePet(pet);
    }

    @Override
    public void deletePet(Integer id) {
        petMapper.deletePet(id);
    }

    @Override
    public void deletePetByUser(Integer id) {
        petMapper.deletePetByUser(id);
    }

    @Override
    public Integer getAdopted(Integer id) {
        return petMapper.getAdopted(id);
    }

    @Override
    public List<Pet> getUnAdopted() {
        return petMapper.getUnAdopted();
    }

    @Override
    public Integer count() {
        return petMapper.count();
    }
}

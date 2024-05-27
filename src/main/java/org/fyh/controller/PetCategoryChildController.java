package org.fyh.controller;

import org.fyh.pojo.PageBean;
import org.fyh.pojo.Pet;
import org.fyh.pojo.PetCategoryChild;
import org.fyh.pojo.Result;
import org.fyh.service.PetCategoryChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/petCategoryChild")
public class PetCategoryChildController {
    @Autowired
    private PetCategoryChildService petCategoryChildService;
    @GetMapping
    public Result<List<PetCategoryChild>> findByFatherId(Integer id){
        List<PetCategoryChild> petCategoryChildList = petCategoryChildService.findByFatherId(id);
        return Result.success(petCategoryChildList);
    }
    @PostMapping("/update")
    public Result update(@RequestBody PetCategoryChild petCategoryChild){
        petCategoryChildService.update(petCategoryChild);
        return Result.success();
    }
    @PostMapping("/add")
    public Result add(@RequestBody PetCategoryChild petCategoryChild){
        petCategoryChildService.add(petCategoryChild);
        return Result.success();
    }
    @DeleteMapping
    public Result delete(Integer id){
        petCategoryChildService.delete(id);
        return Result.success();
    }
    @GetMapping("/all")
    public Result<List<PetCategoryChild>> findAll(Integer id){
        List<PetCategoryChild> petCategoryChildList = petCategoryChildService.findAll(id);
        return Result.success(petCategoryChildList);
    }
    @GetMapping("/all/page")
    public Result<PageBean<PetCategoryChild>> list(
            Integer pageNum,
            Integer pageSize,
            @RequestParam(required = false) String category
    ) {
        PageBean<PetCategoryChild> pageBean = petCategoryChildService.list(pageNum, pageSize, category);
        return Result.success(pageBean);
    }



}

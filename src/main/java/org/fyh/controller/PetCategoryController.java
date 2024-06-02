package org.fyh.controller;

import org.fyh.pojo.PetCategory;
import org.fyh.pojo.Result;
import org.fyh.service.PetCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/petCategory")
public class PetCategoryController {
    @Autowired
    private PetCategoryService petcategoryService;

    @GetMapping
    public Result<List<PetCategory>> list() {
        List<PetCategory> petCategoryList = petcategoryService.list();
        return Result.success(petCategoryList);
    }

    @GetMapping("/get")
    public Result<PetCategory> get(Integer id) {
        PetCategory petCategory = petcategoryService.get(id);
        return Result.success(petCategory);
    }
    @PostMapping("/add")
    public Result addPetCategory(@RequestBody PetCategory petCategory) {
        petcategoryService.addPetCategory(petCategory);
        return Result.success();
    }
    @PostMapping("/update")
    public Result updatePetCategory(@RequestBody PetCategory petCategory) {
        petcategoryService.updatePetCategory(petCategory);
        return Result.success();
    }
    @DeleteMapping
    public Result deletePetCategory(Integer id) {
        petcategoryService.deletePetCategory(id);
        return Result.success();
    }
    @GetMapping("/name")
    public Result getName(@RequestParam Integer id){
        return Result.success(petcategoryService.getName(id));
    }
}

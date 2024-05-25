package org.fyh.controller;

import org.fyh.pojo.PetCategory;
import org.fyh.pojo.Result;
import org.fyh.service.PetCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}

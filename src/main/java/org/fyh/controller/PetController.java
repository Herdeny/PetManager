package org.fyh.controller;

import org.fyh.pojo.PageBean;
import org.fyh.pojo.Pet;
import org.fyh.pojo.Result;
import org.fyh.pojo.User;
import org.fyh.service.PetService;
import org.fyh.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pet")
public class PetController {

    @Autowired
    private PetService petService;

    @PostMapping
    public Result addPet(@RequestBody Pet pet) {
        petService.addPet(pet);
        return Result.success();
    }

    @GetMapping
    public Result<PageBean<Pet>> list(
            Integer pageNum,
            Integer pageSize,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) Boolean isOwned
    ) {
        PageBean<Pet> pageBean = petService.list(pageNum, pageSize, category, isOwned);
        return Result.success(pageBean);
    }
}



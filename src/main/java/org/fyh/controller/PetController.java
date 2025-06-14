package org.fyh.controller;

import org.fyh.pojo.PageBean;
import org.fyh.pojo.Pet;
import org.fyh.pojo.Result;
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
    @PostMapping("/update")
    public Result updatePet(@RequestBody Pet pet) {
        if (!pet.isOwned()){
        System.out.println(pet.getOwnerId());
        }

        petService.updatePet(pet);
        return Result.success();
    }
    @DeleteMapping
    public Result deletePet(Integer id) {
        petService.deletePet(id);
        return Result.success();
    }

    @DeleteMapping("/deletebyuser")
    public Result deletePetByUser(@RequestParam(value = "id")Integer id) {
        petService.deletePetByUser(id);
        return Result.success();
    }

    @GetMapping
    public Result<PageBean<Pet>> list(
            Integer pageNum,
            Integer pageSize,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) Boolean owned,
            @RequestParam(required = false) Integer ownerId
    ) {
        PageBean<Pet> pageBean = petService.list(pageNum, pageSize, category, owned, ownerId);
        return Result.success(pageBean);
    }

    @GetMapping("/check")
    public Result<Pet> get(Integer id) {
        Pet pet = petService.get(id);
        return Result.success(pet);
    }

    @GetMapping("/adopted")
    public Result<Integer> getAdopted() {
        Map<String, Object> claims = ThreadLocalUtil.get();
        int userId = (int) claims.get("id");
        return Result.success(petService.getAdopted(userId));
    }

    @GetMapping("/unAdopted")
    public Result<List<Pet>> getUnAdopted() {
        return Result.success(petService.getUnAdopted());
    }
    @GetMapping("/count")
    public Result<Integer> count() {
        return Result.success(petService.count());
    }

}
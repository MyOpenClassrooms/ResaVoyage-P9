package com.ms.category.controller;

import com.ms.category.entity.Category;
import com.ms.category.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {


    @Autowired
    CategoryRepository repository;


    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<Category> getAllCategories(){
        return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Category findById(@PathVariable Integer id) {
        return repository.getOne(id);
    }


    @GetMapping(value = "/name/{title}")
    public Category findByTitle(@PathVariable String title){
        return repository.getByTitle(title);
    }


}

package com.codeskill.codeskill.controllers;

import com.codeskill.codeskill.models.Category;
import com.codeskill.codeskill.models.Test;
import com.codeskill.codeskill.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @PostMapping
    public Category createCategory(@RequestBody Category category){
        return categoryService.createCategory(category);
    }

    @DeleteMapping ("/{id}")
    public void deleteCategoryById(@PathVariable String id){
        categoryService.deleteCategoryById(id);
    }
}

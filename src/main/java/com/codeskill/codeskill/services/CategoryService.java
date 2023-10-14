package com.codeskill.codeskill.services;

import com.codeskill.codeskill.models.Category;
import com.codeskill.codeskill.models.Test;
import com.codeskill.codeskill.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    public Category createCategory(Category category){
        return categoryRepository.save(category);
    }

    public Optional<Category> getCategoryById(String id){
        return categoryRepository.findById(id);
    }

    public void deleteCategoryById(String id){
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if(categoryOptional.isPresent()){
            Category category = categoryOptional.get();
            List<Test> tests = category.getTests();
            if(tests.isEmpty()){
                categoryRepository.deleteById(id);
            }else{
                throw new RuntimeException("Cannot delete a category with tests");
            }
        }else{
            throw new RuntimeException("Category not found");
        }
    }
}

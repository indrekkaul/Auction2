package com.example.auction.controllers;

import com.example.auction.model.Category;
import com.example.auction.repositorys.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    CategoryRepository categoryRepository;

    @Autowired
    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/registerCategory")
    public String registerCategory(){
        return null;
    }

    @RequestMapping("/allCategorys")
    List<Category> getAllCategorys() {
        return categoryRepository.findAll();
    }


}

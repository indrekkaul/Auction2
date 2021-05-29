package com.example.auction.controllers;

import com.example.auction.model.Category;
import com.example.auction.repositorys.CategoryRepository;
import com.example.auction.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/registerCategory")
    public String registerCategory(){
        return null;
    }

    @RequestMapping("/allCategorys")
    List<Category> getAllCategorys() {
        return categoryService.findAll();
    }


}

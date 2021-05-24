package com.example.auction.services;

import com.example.auction.model.Category;

import java.util.List;

public interface CategoryService {

    Category findOne(Long id);

    List<Category> findAll();

    void save (Category category);

    void update(Long id, Category category);

    void delete (Long id);

    void restore(Long id);

}

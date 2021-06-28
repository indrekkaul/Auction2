package com.auction.services;

import com.auction.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    Optional<Category> findOne(Long id);

    List<Category> findAll();

    List<Category> findAllByNameContaining(String string);

    List<Category> findAllByDescriptionContaining(String string);

    List<Category> findAllByContainingString (String string);

    Category save (Category category);

    Category update(Long id, Category newCategory);

    boolean delete (Long id);

    void restore(Long id);

}

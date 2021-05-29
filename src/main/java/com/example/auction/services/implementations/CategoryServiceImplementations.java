package com.example.auction.services.implementations;

import com.example.auction.model.Category;
import com.example.auction.repositorys.CategoryRepository;
import com.example.auction.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImplementations implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category findOne(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Category not found!"));
    }

    @Override
    public List<Category> findAll() {
        List<Category> categories = new ArrayList<>(categoryRepository.findAll());
        return categories;
    }

    @Override
    public void save(Category category) {
        categoryRepository.saveAndFlush(category);
    }

    @Override
    public void update(Long id, Category category) {
        Category oldCategory = findOne(category.getId());
        oldCategory.setDescription(category.getDescription());
        oldCategory.setName(category.getName());

        save(oldCategory);
    }

    @Override
    public void delete(Long id) {
        Category categoryDelete = findOne(id);
        categoryDelete.setActive(false);
        save(categoryDelete);

    }

    @Override
    public void restore(Long id) {
        Category categoryRestore = findOne(id);
        categoryRestore.setActive(true);
        save(categoryRestore);
    }
}

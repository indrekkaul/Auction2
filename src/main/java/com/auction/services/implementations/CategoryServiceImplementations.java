package com.auction.services.implementations;

import com.auction.repositorys.CategoryRepository;
import com.auction.services.CategoryService;
import com.auction.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CategoryServiceImplementations implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Optional<Category> findOne(Long id) {
        return Optional.ofNullable(categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found!")));
    }

    @Override
    public List<Category> findAll() {
        List<Category> categories = new ArrayList<>(categoryRepository.findAll());
        return categories;
    }

    @Override
    public List<Category> findAllByNameContaining(String string) {
        List<Category> categoriesContainingName = new ArrayList<>(categoryRepository.findAllByNameContaining(string));
        return categoriesContainingName;
    }

    @Override
    public List<Category> findAllByDescriptionContaining(String string) {
        List<Category> categoriesContainingDescription = new ArrayList<>(categoryRepository.findAllByDescriptionContaining(string));
        return categoriesContainingDescription;
    }
    @Override
    public List<Category> findAllByContainingString (String string){
        List<Category> categoriesByString = findAllByDescriptionContaining(string);
        categoriesByString.addAll(findAllByNameContaining(string));
        Set<Category> removeDuplicates = new LinkedHashSet<>(categoriesByString);
        categoriesByString.clear();
        categoriesByString.addAll(removeDuplicates);
        return categoriesByString;
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.saveAndFlush(category);
    }

    @Override
    public Category update(Long id, Category newCategory) {
        Optional<Category> oldCategory = findOne(id);
        if (oldCategory.isPresent()){
            Category tempCategory = oldCategory.get();
            tempCategory.setName(newCategory.getName());
            tempCategory.setDescription(newCategory.getDescription());
            return save(tempCategory);
        }else {
            throw new RuntimeException("Cant update, provided record does not exists!");
        }
    }

    @Override
    public boolean delete(Long id) {
        Category categoryDelete = categoryRepository.getOne(id);
        categoryDelete.setActive(false);
        save(categoryDelete);
        return true;
    }

    @Override
    public void restore(Long id) {
        Category categoryRestore = categoryRepository.getOne(id);
        categoryRestore.setActive(true);
        save(categoryRestore);
    }
}

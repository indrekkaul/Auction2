package com.example.auction.controllers;

import com.example.auction.model.Category;
import com.example.auction.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    /**
     * POST :<code>/category</code>
     * @param category The Category to persist in database
     * @return category created
     */
    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category){
        Category newCategory = categoryService.save(category);
        return new ResponseEntity<>(newCategory, HttpStatus.CREATED);
    }

    /**
     * GET: <code>/category/all</code>
     * @return all category's
     */

    @RequestMapping("/all")
    public ResponseEntity<List<Category>> getAllCategorys(@RequestParam( required = false) String str){
        List<Category> categories = categoryService.findAll();
        if(categories.isEmpty()){
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categories,HttpStatus.OK);
    }

    /**
     * GET: <code>/category/"user input</code>
     * @return all category's by "user input
     *
     */
    @RequestMapping("/{string}")
    public ResponseEntity<List<Category>> getAllByContaining(@PathVariable(value = "string") String string){
        List<Category> categoriesContaining = categoryService.findAllByContainingString(string);
        if(categoriesContaining.isEmpty()){
            return new ResponseEntity<>(Collections.emptyList(),HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoriesContaining,HttpStatus.OK);
    }

    /**
     * PUT: <code>/category/id</code>
     *
     * @param id  The id of the old category to replace
     * @param category The new category
     * @return updated category in database
     */
    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable("id") Long id, @ResponseBody Category category){
        Category newCategory = categoryService.update(id,category);
        if (newCategory == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(newCategory,HttpStatus.OK);
    }

    /**
     * DELETE: <code>/category/id</code>
     *
     * @param id The id of catalog to set inActive
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCatalog(@PathVariable("id") Long id){
        boolean success = categoryService.delete(id);
        if (success){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}

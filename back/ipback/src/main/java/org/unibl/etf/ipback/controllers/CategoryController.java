package org.unibl.etf.ipback.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.unibl.etf.ipback.entities.CategoryEntity;
import org.unibl.etf.ipback.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/categorys")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<CategoryEntity> getAll(){
        return categoryService.getAll();
    }
    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody CategoryEntity categoryEntity){
        categoryService.createOrUpdateCategory(categoryEntity);

        return ResponseEntity.status(HttpStatusCode.valueOf(201)).build();
    }

    @PutMapping
    public ResponseEntity<?> updateCategory(@RequestBody CategoryEntity categoryEntity){
        categoryService.createOrUpdateCategory(categoryEntity);

        return ResponseEntity.status(HttpStatusCode.valueOf(200)).build();
    }

    @DeleteMapping
    public ResponseEntity<?> deleteCategory(@RequestBody CategoryEntity categoryEntity){
        categoryService.deleteCategory(categoryEntity);
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).build();
    }
}

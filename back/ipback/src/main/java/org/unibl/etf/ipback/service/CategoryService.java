package org.unibl.etf.ipback.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unibl.etf.ipback.entities.CategoryEntity;
import org.unibl.etf.ipback.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryEntity> getAll(){
        return categoryRepository.findAll();
    }
    public CategoryEntity getOne(Integer id){
        return categoryRepository.findCategoryEntitiesById(id);
    }

    public CategoryEntity createOrUpdateCategory(CategoryEntity categoryEntity){
        return categoryRepository.save(categoryEntity);
    }
    public void deleteCategory(CategoryEntity categoryEntity){
        categoryRepository.delete(categoryEntity);
    }
}

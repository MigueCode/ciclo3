package com.ciclo3.ciclo3.service;

import com.ciclo3.ciclo3.model.Category;
import com.ciclo3.ciclo3.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll(){
        return categoryRepository.getAll();
    }

    public Optional<Category> getCategory(Integer id){
        return categoryRepository.getCategory(id);
    }

    public Category save(Category category){
        if (category.getId() == null){
            return categoryRepository.save(category);
        } else {
            Optional<Category> auxCategory = categoryRepository.getCategory(category.getId());

            if (auxCategory.isEmpty()){
                return categoryRepository.save(category);
            } else return category;

        }
    }

    public Category update(Category category){
        if (category.getId() != null){
            Optional<Category> auxCategory = categoryRepository.getCategory(category.getId());
            if (auxCategory.isPresent()){
                if (category.getName() != null){
                    auxCategory.get().setName(category.getName());
                }
                if (category.getDescription() != null){
                    auxCategory.get().setDescription(category.getDescription());
                }
                return categoryRepository.save(auxCategory.get());
            }
        }
        return category;
    }

    public boolean delete(Integer id){
        Optional<Category> auxCategory = categoryRepository.getCategory(id);
        if (auxCategory.isPresent()){
            categoryRepository.delete(auxCategory.get());
            return true;
        }

        return false;
    }
}

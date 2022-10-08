package com.mintic.Reto3.Service;

import com.mintic.Reto3.Model.Category;
import com.mintic.Reto3.Repository.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository   categoryRepository;

    public List <Category> getCategoryAll(){
        return categoryRepository.getCategoryAll();
    }
    public Optional <Category> getCategoryId(Integer id){
        return categoryRepository.getCategoryId(id);

    }
    public Category saveCategory  (Category category){
        if (category.getId()==null){
            return categoryRepository.saveCategory(category);
        }else{
           Optional <Category> categoryAuxiliar = categoryRepository.getCategoryId(category.getId());
           if(categoryAuxiliar.isEmpty()){
           return categoryRepository.saveCategory(category);
           }else{
           return category;
           }
        }
    } 
}
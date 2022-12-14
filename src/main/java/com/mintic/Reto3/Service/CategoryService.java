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

    public Category updateCategory(Category category) {
        if (category.getId() != null) {
            Optional<Category> category_update = categoryRepository.getCategoryId(category.getId());
            if (!category_update.isEmpty()) {
                if (category.getDescription() != null) {
                    category_update.get().setDescription(category.getDescription());
                }
                if (category.getName() != null) {
                    category_update.get().setName(category.getName());
                }
                return categoryRepository.saveCategory(category_update.get());
            }
        }
        return category;
    }



    public boolean deleteCategory(Integer categoryId){
        boolean flag=false;
        Optional<Category> category_d=categoryRepository.getCategoryId(categoryId);
        if(category_d.isPresent()){
            categoryRepository.deleteCategory(category_d.get());
            flag=true;
            }
            return flag;
    }


}
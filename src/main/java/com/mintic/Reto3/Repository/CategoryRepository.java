package com.mintic.Reto3.Repository;

import com.mintic.Reto3.Repository.Crud.CategoryCrudRepositoryInterfaz;
import com.mintic.Reto3.Model.Category;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryRepository {
    @Autowired
    private CategoryCrudRepositoryInterfaz categoryCrudRepositoryInterfaz;
    
    public List  <Category> getCategoryAll(){
    return (List<Category>) categoryCrudRepositoryInterfaz.findAll();
    }
    
    public Optional <Category> getCategoryId(Integer id){
        return categoryCrudRepositoryInterfaz.findById(id);
    }
    
    public  Category saveCategory(Category category){
        return categoryCrudRepositoryInterfaz.save(category);
    }

    public void deleteCategory(Category category){
        categoryCrudRepositoryInterfaz.delete(category);
    }
}
package com.csoftware.apiassessment.service;

import java.util.List;
import com.csoftware.apiassessment.model.Categories;
import com.csoftware.apiassessment.model.Tags;

public interface CategoriesService {
 
    public void addCategories(Categories categories);
 
    public List<Categories> getAllCategories();
 
    public void deleteCategories(int categoriesId);
 
    public Categories updateCategories(Categories categories);
 
    public Categories getCategories(int categoriesid);
     
    
    public Categories findOrCreateRecord(String name);
	
	public String getLastGeneratedId();
}


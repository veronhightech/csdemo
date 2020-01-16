package com.csoftware.apiassessment.dao;

import java.util.List;

import com.csoftware.apiassessment.model.Categories;
import com.csoftware.apiassessment.model.Tags;

public interface TagsDAO {
 
    public void addTags(Tags tags);
 
    public List<Tags> getAllTags();
    
    public List<Tags> getProductTags(long product); 
 
    public void deleteTags(int tagsId);
 
    public Tags updateTags(Tags tags);
 
    public Tags getTags(int tagsid);
    
    public Tags findOrCreateRecord(String name);
	
	public String getLastGeneratedId();
}


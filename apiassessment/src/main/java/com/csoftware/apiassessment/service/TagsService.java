package com.csoftware.apiassessment.service;

import java.util.List;
import com.csoftware.apiassessment.model.Tags;

public interface TagsService {
 
    public void addTags(Tags tags);
 
    public List<Tags> getAllTags();
    
    public List<Tags> getProductTags(long l); 
 
    public void deleteTags(int tagsId);
 
    public Tags updateTags(Tags tags);
 
    public Tags getTags(int tagsid);
    
    public Tags findOrCreateRecord(String tagName);
	
	public String getLastGeneratedId();
}


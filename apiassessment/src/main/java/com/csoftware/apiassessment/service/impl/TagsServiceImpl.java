package com.csoftware.apiassessment.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; 
import javax.transaction.Transactional;

import com.csoftware.apiassessment.model.Categories;
import com.csoftware.apiassessment.model.Tags;
import com.csoftware.apiassessment.dao.TagsDAO;
import com.csoftware.apiassessment.service.TagsService;



@Service
@Transactional
public class TagsServiceImpl implements TagsService {

    @Autowired
    private TagsDAO tagsserviceimplDAO;

    @Override
    @Transactional
public void addTags(Tags tagsserviceimpl) {
        tagsserviceimplDAO.addTags(tagsserviceimpl);
 
    }

    @Override
    @Transactional
    public List<Tags> getAllTags() {
        return tagsserviceimplDAO.getAllTags();
    }
    
    @Override
    @Transactional
    public List<Tags> getProductTags(long product) {
        return tagsserviceimplDAO.getProductTags(product);
    }

    @Override
    @Transactional
    public void deleteTags(int tagsserviceimplId) {
        tagsserviceimplDAO.deleteTags(tagsserviceimplId);
    }

    @Override
    @Transactional
    public Tags getTags(int tagsserviceimplId) {
        return tagsserviceimplDAO.getTags(tagsserviceimplId);
    }
    
    @Override
    @Transactional
    public Tags findOrCreateRecord(String name) {
        return tagsserviceimplDAO.findOrCreateRecord(name);
    }
     

    @Override
    @Transactional
    public Tags updateTags(Tags tagsserviceimpl) {
        // TODO Auto-generated method stub
        return tagsserviceimplDAO.updateTags(tagsserviceimpl);
    }

    public void setTagsDAO(TagsDAO tagsserviceimplDAO) {
        this.tagsserviceimplDAO = tagsserviceimplDAO;
    }

	public String getLastGeneratedId(){
		return tagsserviceimplDAO.getLastGeneratedId();
	}



}

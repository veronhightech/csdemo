package com.csoftware.apiassessment.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; 
import javax.transaction.Transactional;
import com.csoftware.apiassessment.model.Taggedproducts;
import com.csoftware.apiassessment.dao.TaggedproductsDAO;
import com.csoftware.apiassessment.service.TaggedproductsService;



@Service
@Transactional
public class TaggedproductsServiceImpl implements TaggedproductsService {

    @Autowired
    private TaggedproductsDAO taggedproductsserviceimplDAO;

    @Override
    @Transactional
public void addTaggedproducts(Taggedproducts taggedproductsserviceimpl) {
        taggedproductsserviceimplDAO.addTaggedproducts(taggedproductsserviceimpl);
 
    }

    @Override
    @Transactional
    public List<Taggedproducts> getAllTaggedproducts() {
        return taggedproductsserviceimplDAO.getAllTaggedproducts();
    }

    @Override
    @Transactional
    public void deleteTaggedproducts(long taggedproductsserviceimplId) {
        taggedproductsserviceimplDAO.deleteTaggedproducts(taggedproductsserviceimplId);
    }

    @Override
    @Transactional
    public Taggedproducts getTaggedproducts(long taggedproductsserviceimplId) {
        return taggedproductsserviceimplDAO.getTaggedproducts(taggedproductsserviceimplId);
    }

    @Override
    @Transactional
    public Taggedproducts updateTaggedproducts(Taggedproducts taggedproductsserviceimpl) {
        // TODO Auto-generated method stub
        return taggedproductsserviceimplDAO.updateTaggedproducts(taggedproductsserviceimpl);
    }

    public void setTaggedproductsDAO(TaggedproductsDAO taggedproductsserviceimplDAO) {
        this.taggedproductsserviceimplDAO = taggedproductsserviceimplDAO;
    }

	public String getLastGeneratedId(){
		return taggedproductsserviceimplDAO.getLastGeneratedId();
	}



}

package com.csoftware.apiassessment.service;

import java.util.List;
import com.csoftware.apiassessment.model.Taggedproducts;

public interface TaggedproductsService {
 
    public void addTaggedproducts(Taggedproducts taggedproducts);
 
    public List<Taggedproducts> getAllTaggedproducts();
 
    public void deleteTaggedproducts(long taggedproductsId);
 
    public Taggedproducts updateTaggedproducts(Taggedproducts taggedproducts);
 
    public Taggedproducts getTaggedproducts(long taggedproductsid);
	
	public String getLastGeneratedId();
}


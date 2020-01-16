package com.csoftware.apiassessment.service;

import java.util.List;
import com.csoftware.apiassessment.model.Brands;

public interface BrandsService {
 
    public void addBrands(Brands brands);
 
    public List<Brands> getAllBrands();
 
    public void deleteBrands(int brandsId);
 
    public Brands updateBrands(Brands brands);
 
    public Brands getBrands(int brandsid);
    
    public Brands findOrCreateBrands(String brandName);
	
	public String getLastGeneratedId();
}


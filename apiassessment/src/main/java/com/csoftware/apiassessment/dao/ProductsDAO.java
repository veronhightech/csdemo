package com.csoftware.apiassessment.dao;

import java.util.List;

import com.csoftware.apiassessment.dto.ProductsDTO;
import com.csoftware.apiassessment.model.Products;

public interface ProductsDAO {
 
    public Products addProducts(Products products);
    
    public ProductsDTO getProductsWithDTO(Long id);
 
    public List<Products> getAllProducts();
    
    public List<ProductsDTO> getAllProductsDTO();
    
    public List<ProductsDTO> getSearchedProductsDTO(int starPage, int recordLimit, String search, List<String> fields); 
 
    public void deleteProducts(long productsId);
 
    public Products updateProducts(Products products);
 
    public Products getProducts(long productsid);
	
	public String getLastGeneratedId();
}


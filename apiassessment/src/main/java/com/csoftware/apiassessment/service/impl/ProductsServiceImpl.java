package com.csoftware.apiassessment.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; 
import javax.transaction.Transactional;
import com.csoftware.apiassessment.model.Products;
import com.csoftware.apiassessment.dao.ProductsDAO;
import com.csoftware.apiassessment.dto.ProductsDTO;
import com.csoftware.apiassessment.service.ProductsService;



@Service
@Transactional
public class ProductsServiceImpl implements ProductsService {

    @Autowired
    private ProductsDAO productsserviceimplDAO;

    @Override
    @Transactional
    public Products addProducts(Products productsserviceimpl) {
        return productsserviceimplDAO.addProducts(productsserviceimpl);
 
    }
    
    @Override
    @Transactional
    public ProductsDTO getProductsWithDTO(Long id) {
        return productsserviceimplDAO.getProductsWithDTO(id);
 
    }

    @Override
    @Transactional
    public List<Products> getAllProducts() {
        return productsserviceimplDAO.getAllProducts();
    }
    
    @Override
    @Transactional
    public List<ProductsDTO> getAllProductsDTO() {
        return productsserviceimplDAO.getAllProductsDTO();
    }
    
    @Override
    @Transactional
    public List<ProductsDTO> getSearchedProductsDTO(int starPage, int recordLimit, String search, List<String> fields) {
        return productsserviceimplDAO.getSearchedProductsDTO(starPage, recordLimit, search, fields);
    }

    @Override
    @Transactional
    public void deleteProducts(long productsserviceimplId) {
        productsserviceimplDAO.deleteProducts(productsserviceimplId);
    }

    @Override
    @Transactional
    public Products getProducts(long productsserviceimplId) {
        return productsserviceimplDAO.getProducts(productsserviceimplId);
    }

    @Override
    @Transactional
    public Products updateProducts(Products productsserviceimpl) {
        // TODO Auto-generated method stub
        return productsserviceimplDAO.updateProducts(productsserviceimpl);
    }

    public void setProductsDAO(ProductsDAO productsserviceimplDAO) {
        this.productsserviceimplDAO = productsserviceimplDAO;
    }

	public String getLastGeneratedId(){
		return productsserviceimplDAO.getLastGeneratedId();
	}



}

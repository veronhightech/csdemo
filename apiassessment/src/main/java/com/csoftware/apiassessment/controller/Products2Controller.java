package com.csoftware.apiassessment.controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.csoftware.apiassessment.model.Products;
import com.csoftware.apiassessment.service.ProductsService;


@CrossOrigin()
@Controller
@RequestMapping(value = "/products2")
public class Products2Controller {
    private static final Logger logger = Logger.getLogger(Products2Controller.class);

    @Autowired
    private ProductsService productsService;
    @Autowired
	ServletContext servletContext;

	@RequestMapping(value = "/")
    public ResponseEntity<List<Products>>  listProductsDefault() throws IOException { 
    	List<Products> listProducts = productsService.getAllProducts(); 
        
        return new ResponseEntity<List<Products>>(listProducts, HttpStatus.OK);
    }


	@RequestMapping(value = "/list")
    public ResponseEntity<List<Products>>  listProducts() throws IOException { 
    	List<Products> listProducts = productsService.getAllProducts(); 
        
        return new ResponseEntity<List<Products>>(listProducts, HttpStatus.OK);
    }


    @RequestMapping(value = "/{id}")
    public ResponseEntity<Products>  singleProducts(@PathVariable("id") int id) throws IOException {
        
    	Products products = productsService.getProducts(id);
                
        return new ResponseEntity<Products>(products, HttpStatus.OK);
    }



	@RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<Products> createProducts(@RequestBody Products products, 
    		HttpServletRequest request)  throws IOException{
    	
    	productsService.addProducts(products);
		Integer lastId = Integer.parseInt(productsService.getLastGeneratedId()); 
		
        Products productsx = productsService.getProducts(lastId); 
         
        return new ResponseEntity<Products>(productsx, HttpStatus.OK);
        
    }	




    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<Products> saveProducts(@RequestBody Products products, 
    		HttpServletRequest request)  throws IOException{
    	
		productsService.updateProducts(products);
		
        Products productsx = productsService.getProducts(products.getId()); 
         
        return new ResponseEntity<Products>(productsx, HttpStatus.OK);
        
    }




	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Products> deleteProducts(@PathVariable("id") int id, HttpServletRequest request) throws IOException {
        int productsId = id;
        //int productsId = Integer.parseInt(request.getParameter("id"));
        productsService.deleteProducts(productsId);
        Products products = null;
        
		return new ResponseEntity<Products>(products, HttpStatus.OK);
    }




}
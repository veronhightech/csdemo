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
import com.csoftware.apiassessment.model.Brands;
import com.csoftware.apiassessment.service.BrandsService;


@CrossOrigin()
@Controller
@RequestMapping(value = "/brands")
public class BrandsController {
    private static final Logger logger = Logger.getLogger(BrandsController.class);

    @Autowired
    private BrandsService brandsService;
    @Autowired
	ServletContext servletContext;

	@RequestMapping(value = "/")
    public ResponseEntity<List<Brands>>  listBrandsDefault() throws IOException { 
    	List<Brands> listBrands = brandsService.getAllBrands(); 
        
        return new ResponseEntity<List<Brands>>(listBrands, HttpStatus.OK);
    }


	@RequestMapping(value = "/list")
    public ResponseEntity<List<Brands>>  listBrands() throws IOException { 
    	List<Brands> listBrands = brandsService.getAllBrands(); 
        
        return new ResponseEntity<List<Brands>>(listBrands, HttpStatus.OK);
    }


    @RequestMapping(value = "/{id}")
    public ResponseEntity<Brands>  singleBrands(@PathVariable("id") int id) throws IOException {
        
    	Brands brands = brandsService.getBrands(id);
                
        return new ResponseEntity<Brands>(brands, HttpStatus.OK);
    }



	@RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<Brands> createBrands(@RequestBody Brands brands, 
    		HttpServletRequest request)  throws IOException{
    	
    	brandsService.addBrands(brands);
		Integer lastId = Integer.parseInt(brandsService.getLastGeneratedId()); 
		
        Brands brandsx = brandsService.getBrands(lastId); 
         
        return new ResponseEntity<Brands>(brandsx, HttpStatus.OK);
        
    }	




    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<Brands> saveBrands(@RequestBody Brands brands, 
    		HttpServletRequest request)  throws IOException{
    	
		brandsService.updateBrands(brands);
		
        Brands brandsx = brandsService.getBrands(brands.getBrandId()); 
         
        return new ResponseEntity<Brands>(brandsx, HttpStatus.OK);
        
    }




	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Brands> deleteBrands(@PathVariable("id") int id, HttpServletRequest request) throws IOException {
        int brandsId = id;
        //int brandsId = Integer.parseInt(request.getParameter("id"));
        brandsService.deleteBrands(brandsId);
        Brands brands = null;
        
		return new ResponseEntity<Brands>(brands, HttpStatus.OK);
    }




}
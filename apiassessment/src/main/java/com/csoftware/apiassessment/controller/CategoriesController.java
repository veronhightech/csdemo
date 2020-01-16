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
import com.csoftware.apiassessment.model.Categories;
import com.csoftware.apiassessment.service.CategoriesService;


@CrossOrigin()
@Controller
@RequestMapping(value = "/categories")
public class CategoriesController {
    private static final Logger logger = Logger.getLogger(CategoriesController.class);

    @Autowired
    private CategoriesService categoriesService;
    @Autowired
	ServletContext servletContext;

	@RequestMapping(value = "/")
    public ResponseEntity<List<Categories>>  listCategoriesDefault() throws IOException { 
    	List<Categories> listCategories = categoriesService.getAllCategories(); 
        
        return new ResponseEntity<List<Categories>>(listCategories, HttpStatus.OK);
    }


	@RequestMapping(value = "/list")
    public ResponseEntity<List<Categories>>  listCategories() throws IOException { 
    	List<Categories> listCategories = categoriesService.getAllCategories(); 
        
        return new ResponseEntity<List<Categories>>(listCategories, HttpStatus.OK);
    }


    @RequestMapping(value = "/{id}")
    public ResponseEntity<Categories>  singleCategories(@PathVariable("id") int id) throws IOException {
        
    	Categories categories = categoriesService.getCategories(id);
                
        return new ResponseEntity<Categories>(categories, HttpStatus.OK);
    }



	@RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<Categories> createCategories(@RequestBody Categories categories, 
    		HttpServletRequest request)  throws IOException{
    	
    	categoriesService.addCategories(categories);
		Integer lastId = Integer.parseInt(categoriesService.getLastGeneratedId()); 
		
        Categories categoriesx = categoriesService.getCategories(lastId); 
         
        return new ResponseEntity<Categories>(categoriesx, HttpStatus.OK);
        
    }	




    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<Categories> saveCategories(@RequestBody Categories categories, 
    		HttpServletRequest request)  throws IOException{
    	
		categoriesService.updateCategories(categories);
		
        Categories categoriesx = categoriesService.getCategories(categories.getCategoryId()); 
         
        return new ResponseEntity<Categories>(categoriesx, HttpStatus.OK);
        
    }




	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Categories> deleteCategories(@PathVariable("id") int id, HttpServletRequest request) throws IOException {
        int categoriesId = id;
        //int categoriesId = Integer.parseInt(request.getParameter("id"));
        categoriesService.deleteCategories(categoriesId);
        Categories categories = null;
        
		return new ResponseEntity<Categories>(categories, HttpStatus.OK);
    }




}
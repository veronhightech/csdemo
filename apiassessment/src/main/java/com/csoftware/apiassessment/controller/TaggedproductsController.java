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
import com.csoftware.apiassessment.model.Taggedproducts;
import com.csoftware.apiassessment.service.TaggedproductsService;


@CrossOrigin()
@Controller
@RequestMapping(value = "/taggedproducts")
public class TaggedproductsController {
    private static final Logger logger = Logger.getLogger(TaggedproductsController.class);

    @Autowired
    private TaggedproductsService taggedproductsService;
    @Autowired
	ServletContext servletContext;

	@RequestMapping(value = "/")
    public ResponseEntity<List<Taggedproducts>>  listTaggedproductsDefault() throws IOException { 
    	List<Taggedproducts> listTaggedproducts = taggedproductsService.getAllTaggedproducts(); 
        
        return new ResponseEntity<List<Taggedproducts>>(listTaggedproducts, HttpStatus.OK);
    }


	@RequestMapping(value = "/list")
    public ResponseEntity<List<Taggedproducts>>  listTaggedproducts() throws IOException { 
    	List<Taggedproducts> listTaggedproducts = taggedproductsService.getAllTaggedproducts(); 
        
        return new ResponseEntity<List<Taggedproducts>>(listTaggedproducts, HttpStatus.OK);
    }


    @RequestMapping(value = "/{id}")
    public ResponseEntity<Taggedproducts>  singleTaggedproducts(@PathVariable("id") int id) throws IOException {
        
    	Taggedproducts taggedproducts = taggedproductsService.getTaggedproducts(id);
                
        return new ResponseEntity<Taggedproducts>(taggedproducts, HttpStatus.OK);
    }



	@RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<Taggedproducts> createTaggedproducts(@RequestBody Taggedproducts taggedproducts, 
    		HttpServletRequest request)  throws IOException{
    	
    	taggedproductsService.addTaggedproducts(taggedproducts);
		Integer lastId = Integer.parseInt(taggedproductsService.getLastGeneratedId()); 
		
        Taggedproducts taggedproductsx = taggedproductsService.getTaggedproducts(lastId); 
         
        return new ResponseEntity<Taggedproducts>(taggedproductsx, HttpStatus.OK);
        
    }	




    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<Taggedproducts> saveTaggedproducts(@RequestBody Taggedproducts taggedproducts, 
    		HttpServletRequest request)  throws IOException{
    	
		taggedproductsService.updateTaggedproducts(taggedproducts);
		
        Taggedproducts taggedproductsx = taggedproductsService.getTaggedproducts(taggedproducts.getTaggedProdId()); 
         
        return new ResponseEntity<Taggedproducts>(taggedproductsx, HttpStatus.OK);
        
    }




	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Taggedproducts> deleteTaggedproducts(@PathVariable("id") int id, HttpServletRequest request) throws IOException {
        int taggedproductsId = id;
        //int taggedproductsId = Integer.parseInt(request.getParameter("id"));
        taggedproductsService.deleteTaggedproducts(taggedproductsId);
        Taggedproducts taggedproducts = null;
        
		return new ResponseEntity<Taggedproducts>(taggedproducts, HttpStatus.OK);
    }




}
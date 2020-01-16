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
import com.csoftware.apiassessment.model.Tags;
import com.csoftware.apiassessment.service.TagsService;


@CrossOrigin()
@Controller
@RequestMapping(value = "/tags")
public class TagsController {
    private static final Logger logger = Logger.getLogger(TagsController.class);

    @Autowired
    private TagsService tagsService;
    @Autowired
	ServletContext servletContext;

	@RequestMapping(value = "/")
    public ResponseEntity<List<Tags>>  listTagsDefault() throws IOException { 
    	List<Tags> listTags = tagsService.getAllTags(); 
        
        return new ResponseEntity<List<Tags>>(listTags, HttpStatus.OK);
    }


	@RequestMapping(value = "/list")
    public ResponseEntity<List<Tags>>  listTags() throws IOException { 
    	List<Tags> listTags = tagsService.getAllTags(); 
        
        return new ResponseEntity<List<Tags>>(listTags, HttpStatus.OK);
    }


    @RequestMapping(value = "/{id}")
    public ResponseEntity<Tags>  singleTags(@PathVariable("id") int id) throws IOException {
        
    	Tags tags = tagsService.getTags(id);
                
        return new ResponseEntity<Tags>(tags, HttpStatus.OK);
    }



	@RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<Tags> createTags(@RequestBody Tags tags, 
    		HttpServletRequest request)  throws IOException{
    	
    	tagsService.addTags(tags);
		Integer lastId = Integer.parseInt(tagsService.getLastGeneratedId()); 
		
        Tags tagsx = tagsService.getTags(lastId); 
         
        return new ResponseEntity<Tags>(tagsx, HttpStatus.OK);
        
    }	




    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<Tags> saveTags(@RequestBody Tags tags, 
    		HttpServletRequest request)  throws IOException{
    	
		tagsService.updateTags(tags);
		
        Tags tagsx = tagsService.getTags(tags.getTagId()); 
         
        return new ResponseEntity<Tags>(tagsx, HttpStatus.OK);
        
    }




	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Tags> deleteTags(@PathVariable("id") int id, HttpServletRequest request) throws IOException {
        int tagsId = id;
        //int tagsId = Integer.parseInt(request.getParameter("id"));
        tagsService.deleteTags(tagsId);
        Tags tags = null;
        
		return new ResponseEntity<Tags>(tags, HttpStatus.OK);
    }




}
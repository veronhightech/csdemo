package com.csoftware.apiassessment.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.modelmapper.ModelMapper;
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

import com.csoftware.apiassessment.dto.ProductsDTO;
import com.csoftware.apiassessment.dto.SearchProductsDTO;
import com.csoftware.apiassessment.model.Brands;
import com.csoftware.apiassessment.model.Categories;
import com.csoftware.apiassessment.model.Products;
import com.csoftware.apiassessment.model.Taggedproducts;
import com.csoftware.apiassessment.model.Tags;
import com.csoftware.apiassessment.service.BrandsService;
import com.csoftware.apiassessment.service.CategoriesService;
import com.csoftware.apiassessment.service.ProductsService;
import com.csoftware.apiassessment.service.TaggedproductsService;
import com.csoftware.apiassessment.service.TagsService;


@CrossOrigin()
@Controller
@RequestMapping(value = "/products")
public class ProductsController {
    private static final Logger logger = Logger.getLogger(ProductsController.class);

    @Autowired
    private ProductsService productsService;
    
    @Autowired
    private TagsService tagsService;
    
    @Autowired
    private BrandsService brandsService;
    
    @Autowired
    private CategoriesService categoriesService;
    
    @Autowired
    private TaggedproductsService taggedproductsService;
    
    
    
    @Autowired
    private ModelMapper modelMapper;
    
    @Autowired
	ServletContext servletContext;

	@RequestMapping(value = "/")
    public ResponseEntity<List<ProductsDTO>>  listProductsDefault() throws IOException { 
    	List<ProductsDTO> listProducts = productsService.getAllProductsDTO();  
        
    	List<ProductsDTO> listProductsx =listProducts.stream()
		          .map(this::addTagsToDto)
		          .collect(Collectors.toList());
    	 
    	return new ResponseEntity<List<ProductsDTO>>(listProductsx, HttpStatus.OK);
    }


	@RequestMapping(value = "/list")
    public ResponseEntity<List<ProductsDTO>>  listProducts() throws IOException { 
    	List<ProductsDTO> listProducts = productsService.getAllProductsDTO(); 
    	 
    	List<ProductsDTO> listProductsx =listProducts.stream()
		          .map(this::addTagsToDto)
		          .collect(Collectors.toList());
    	 
		 
    	return new ResponseEntity<List<ProductsDTO>>(listProductsx, HttpStatus.OK);
    }
	
	
	@RequestMapping(value = {"/search", "/search/{search}", "/search/{search}/{starPage}", "/search/{search}/{starPage}/{recordLimit}"})
    public ResponseEntity<List<ProductsDTO>>  listSearchedProducts(@RequestBody(required = false) SearchProductsDTO searchUI,
    		@PathVariable(required = false) Map<String, String> pathVarsMap,
    		HttpServletRequest request) throws IOException { 
		 
	    if (searchUI == null) { 
	    	//if it is GET well use varable path to make search
	    	String searchTxt = pathVarsMap.get("search");
			String starPageTxt = pathVarsMap.get("starPage");
			String recordLimitTxt = pathVarsMap.get("recordLimit");
	    	searchUI=new SearchProductsDTO();
	        if (searchTxt != null) { 
	        	 searchUI.search=searchTxt;  
	        }
	        if (starPageTxt != null) { 
	        	 searchUI.starPage=Integer.valueOf(starPageTxt);  
	        }
	        if (recordLimitTxt != null) { 
	        	 searchUI.recordLimit=Integer.valueOf(recordLimitTxt);  
	        }
	    } 
	    
		int starPage=1;
		int recordLimit=2;
		String search="";
		List<String> fields=new ArrayList<>(); 
		fields.add("category"); //add as default but it could be empty or any will search on the category field
    	
		if(searchUI.starPage!=null){
			starPage=searchUI.starPage; 
	    }
		if(searchUI.recordLimit!=null){
			recordLimit=searchUI.recordLimit; 
	    }
		if(searchUI.search!=null){
			search=searchUI.search; 
	    }
		if(searchUI.fields!=null){
			fields=searchUI.fields; 
	    }
		 
		List<ProductsDTO> listProducts = productsService.getSearchedProductsDTO(starPage, recordLimit, search, fields);
    	 
        
    	List<ProductsDTO> listProductsx =listProducts.stream()
		          .map(this::addTagsToDto)
		          .collect(Collectors.toList());
    	 
		 
    	return new ResponseEntity<List<ProductsDTO>>(listProductsx, HttpStatus.OK);
    }
	
	//to map back and forth and convert to DTO	
	private ProductsDTO convertToDto(Products product) {
	    ProductsDTO prodDto = modelMapper.map(product, ProductsDTO.class);
	    List<Tags> listTags = tagsService.getProductTags(Long.parseLong(prodDto.getId())); //.getAllTags(); 
	    
	    List <String> list= listTags.stream().
	    		map(t ->t.getName()).collect(Collectors.toList());
	    		 
	    prodDto.setTags(list.stream().toArray(String[]::new));
	    
	    return prodDto;
	}
	
	private ProductsDTO addTagsToDto(ProductsDTO product) {
	    //ProductsDTO prodDto = modelMapper.map(product, ProductsDTO.class);
	    List<Tags> listTags = tagsService.getProductTags(Long.parseLong(product.getId())); //.getAllTags(); 
	    
	    List <String> list= listTags.stream().
	    		map(t ->t.getName()).collect(Collectors.toList());
	    		 
	    product.setTags(list.stream().toArray(String[]::new));
	    
	    return product;
	}


    @RequestMapping(value = "/{id}")
    public ResponseEntity<Products>  singleProducts(@PathVariable("id") int id) throws IOException {
        
    	Products products = productsService.getProducts(id);
                
        return new ResponseEntity<Products>(products, HttpStatus.OK);
    }



	@RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<ProductsDTO> createProducts(@RequestBody @Valid ProductsDTO productBlock, 
    		HttpServletRequest request)  throws IOException{
    	
		Brands brand = brandsService.findOrCreateBrands(productBlock.getBrand());
		
		Categories category = categoriesService.findOrCreateRecord(productBlock.getCategory());
		 
		//product creation 
		Products products=new Products();
		products.setBrand(brand.getBrandId());
		products.setCategory(category.getCategoryId());
		products.setName(productBlock.getName());
		products.setDescription(productBlock.getDescription());
		products=productsService.addProducts(products);
		Integer lastId = Integer.parseInt(""+products.getId()); //get the auto generated id
    	
		//we're looking for each tag & adding if not exists we add and prod tag record  
		if(lastId > 0){
			for(String tag: productBlock.getTags()){ 
				Tags tags = tagsService.findOrCreateRecord(tag); 
				if(tags.getTagId() > 0){
					Taggedproducts taggedproduct=new Taggedproducts();
					taggedproduct.setProduct(lastId);
					taggedproduct.setTag(tags.getTagId());
					taggedproductsService.addTaggedproducts(taggedproduct); 
				}
		    }
			 
	    }
		  
        ProductsDTO productsx = productsService.getProductsWithDTO(products.getId()); 
        productsx=addTagsToDto(productsx); 
         
        return new ResponseEntity<ProductsDTO>(productsx, HttpStatus.OK);
        
    }	



	//basic update functionality without DTO for only one table in DB
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
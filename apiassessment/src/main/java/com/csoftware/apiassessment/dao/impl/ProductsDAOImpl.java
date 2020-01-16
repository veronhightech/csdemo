package com.csoftware.apiassessment.dao.impl;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.transform.BasicTransformerAdapter;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.csoftware.apiassessment.model.Brands;
import com.csoftware.apiassessment.model.Products;
import com.csoftware.apiassessment.utils.Pager;
import com.csoftware.apiassessment.dao.ProductsDAO;
import com.csoftware.apiassessment.dto.ProductsDTO;
import com.csoftware.apiassessment.errors.NoResultException;



@Repository
public class ProductsDAOImpl implements ProductsDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Products addProducts(Products productsdaoimpl) {
        sessionFactory.getCurrentSession().saveOrUpdate(productsdaoimpl);
        String idx=getLastGeneratedId();
        Products record =getProducts(Integer.parseInt(idx));
        return record;

    }
    
    @Override
    public ProductsDTO getProductsWithDTO(Long id) {
        ProductsDTO record = getProductsDTO(id);
        return record;
    }

    @Override
	@SuppressWarnings("unchecked")
	public List<Products> getAllProducts() {
		 
	    return sessionFactory.getCurrentSession().createQuery("from Products")
	            .list();
	}

    @Override
	@SuppressWarnings({ "unchecked", "deprecation" })
    public List<ProductsDTO> getAllProductsDTO() {        
         String SQL_QUERY ="SELECT e.id, e.name, e.description, b.name AS brand, c.name AS category, e.created_at FROM Products AS e, Brands AS b, Categories AS c WHERE e.brand=b.brandId AND e.category=c.categoryId";
		 Query query = sessionFactory.getCurrentSession().createQuery(SQL_QUERY);
		 //query.setParameter("id", product); // t.tag=e.tagId AND t.product=:id
	 		 
		 return query.setResultTransformer(new BasicTransformerAdapter() {

             private static final long serialVersionUID = 1L;
             public Object transformTuple(Object[] tuple, String[] aliases)
             {
            	 ProductsDTO prod=new ProductsDTO();
            	 prod.setId(""+(long)tuple[0]);
            	 prod.setName((String)tuple[1]);
            	 prod.setDescription((String)tuple[2]);
            	 prod.setBrand((String)tuple[3]);
            	 prod.setCategory((String)tuple[4]);
            	 prod.setCreated_at((Timestamp)tuple[5]); 
            	                                 
                 return prod;

             }


         }).list();
		 
    }
	
	
	@SuppressWarnings({ "unchecked", "deprecation" })
    public List<ProductsDTO> getSearchedProductsDTO(int starPage, int recordLimit, String search, List<String> fields) { //String[] fields
  
		int myPage=starPage >0? (starPage-1): 0;       
        
        String SQL_QUERY ="SELECT e.id, e.name, e.description, b.name AS brand, c.name AS category, e.created_at FROM Products AS e, Brands AS b, Categories AS c WHERE e.brand=b.brandId AND e.category=c.categoryId";
        if(fields.contains("") || fields.contains("any")  || fields.contains("category")) {
        	SQL_QUERY +=" AND c.name=:cat ";  
		 }
		 if(fields.contains("id")) {
			 SQL_QUERY +=" AND e.id=:id ";  
		 }
		 if(fields.contains("name")) {
			 SQL_QUERY +=" AND e.name=:name ";  
		 }
		 if(fields.contains("brand")) {
			 SQL_QUERY +=" AND b.name=:brand "; 
		 }
		 
		 SQL_QUERY +=" ORDER BY  e.created_at DESC  "; 
		  
		 Query query = sessionFactory.getCurrentSession().createQuery(SQL_QUERY); 
		 if(fields.contains("") || fields.contains("any")  || fields.contains("category")) {
			 query.setParameter("cat", search);  
		 }
		 if(fields.contains("id")) {
			 query.setParameter("id", search);  
		 }
		 if(fields.contains("name")) {
			 query.setParameter("name", search); 
		 }
		 if(fields.contains("brand")) {
			 query.setParameter("brand", search);  
		 }
	 		 
		 //return query.list();
		 //query.setResultTransformer(Transformers.aliasToBean(ProductsDTO.class));
		 //return query.list();
		 
		 List<ProductsDTO> foundRecs= query.setResultTransformer(new BasicTransformerAdapter() {

             private static final long serialVersionUID = 1L;
             public Object transformTuple(Object[] tuple, String[] aliases)
             {
            	 ProductsDTO prod=new ProductsDTO();
            	 prod.setId(""+(long)tuple[0]);
            	 prod.setName((String)tuple[1]);
            	 prod.setDescription((String)tuple[2]);
            	 prod.setBrand((String)tuple[3]);
            	 prod.setCategory((String)tuple[4]);
            	 prod.setCreated_at((Timestamp)tuple[5]);
            	             	                                 
                 return prod;

             }


         }).list();
		 
		 // }).list().subList(myPage * recordLimit, (myPage+1)*recordLimit);
		  
		long totalFoundRows= foundRecs==null? 0:foundRecs.size(); 
		int maxp=((int)(Math.ceil((double)totalFoundRows/recordLimit)));		
		Pager pager=new Pager();
		pager.getPagerData(totalFoundRows, maxp, recordLimit, starPage);
		long offset = pager.offset;
		long limit  = pager.limit;
		long page   = pager.page;
		long maxpage=pager.num_pages;
		
		System.out.println(" RL="+recordLimit+" vs "+totalFoundRows+" off="+offset+" ");
		
		if(totalFoundRows==0){
			System.out.println("eeeeeeeeeeeeeeeeeeee out no more");
	        throw new NoResultException();
	    }
		
		myPage=Integer.parseInt(""+page)-1;
		recordLimit=Integer.parseInt(""+limit);
		int totalTo=(myPage+1)*recordLimit;
		/*if(recordLimit >totalFoundRows){
			recordLimit=Integer.parseInt(""+totalFoundRows)-1;
	    }*/
		
		System.out.println(" RL="+recordLimit+" vs "+totalFoundRows+" STRT="+(myPage * recordLimit)+" ");
		
		if(totalTo >totalFoundRows){
			totalTo=Integer.parseInt(""+totalFoundRows);
	    }
		
		System.out.println(""+foundRecs.size()+" vs "+totalFoundRows+" off="+offset+" ");
		System.out.println("lim="+limit+" pg="+page+" mxp="+maxpage+" "+" mypg="+myPage+" rcl="+recordLimit+" rtot="+totalTo);
			
		 return foundRecs.subList(myPage * recordLimit, totalTo);
    }

	
    @Override
    public void deleteProducts(long productsdaoimplId) {
        Products productsdaoimpl = (Products) sessionFactory.getCurrentSession().load(
                Products.class, productsdaoimplId);
        if (null != productsdaoimpl) {
            this.sessionFactory.getCurrentSession().delete(productsdaoimpl);
        }
 
    }



    public Products getProducts(long productsdaoimplId) {
        return (Products) sessionFactory.getCurrentSession().get(
                Products.class, productsdaoimplId);
    }
    
    @SuppressWarnings({ "deprecation", "unchecked" })
    public ProductsDTO getProductsDTO(long productsdaoimplId) {
    	String SQL_QUERY ="SELECT e.id, e.name, e.description, b.name AS brand, c.name AS category, e.created_at FROM Products AS e, Brands AS b, Categories AS c WHERE e.brand=b.brandId AND e.category=c.categoryId";
          SQL_QUERY +=" AND e.id=:id ";    	  
		 
		 Query query = sessionFactory.getCurrentSession().createQuery(SQL_QUERY);
		 query.setParameter("id", productsdaoimplId);  
		  
		List<ProductsDTO> foundRecs= query.setResultTransformer(new BasicTransformerAdapter() {

             private static final long serialVersionUID = 1L;
             public Object transformTuple(Object[] tuple, String[] aliases)
             {
            	 ProductsDTO prod=new ProductsDTO();
            	 prod.setId(""+(long)tuple[0]);
            	 prod.setName((String)tuple[1]);
            	 prod.setDescription((String)tuple[2]);
            	 prod.setBrand((String)tuple[3]);
            	 prod.setCategory((String)tuple[4]);
            	 prod.setCreated_at((Timestamp)tuple[5]); 
            	                                 
                 return prod;
             }

         }).list();
		
		if(foundRecs==null){
			 return null;
        }
		  
        return foundRecs.get(0);
    }

    @Override
    public Products updateProducts(Products productsdaoimpl) {
        sessionFactory.getCurrentSession().update(productsdaoimpl);
        return productsdaoimpl;
    }



	public String getLastGeneratedId(){
		//String lastId = ((String) sessionFactory.getCurrentSession().createSQLQuery("SELECT LAST_INSERT_ID()").uniqueResult()).toString();
		String lastId =""+ ((BigInteger) sessionFactory.getCurrentSession().createSQLQuery("SELECT LAST_INSERT_ID()").uniqueResult()).longValue();
		return lastId;
	}


}

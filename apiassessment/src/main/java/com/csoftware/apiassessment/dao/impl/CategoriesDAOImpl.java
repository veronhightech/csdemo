package com.csoftware.apiassessment.dao.impl;

import java.math.BigInteger;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.csoftware.apiassessment.model.Brands;
import com.csoftware.apiassessment.model.Categories;
import com.csoftware.apiassessment.dao.CategoriesDAO;



@Repository
public class CategoriesDAOImpl implements CategoriesDAO {

    @Autowired
    private SessionFactory sessionFactory;

public void addCategories(Categories categoriesdaoimpl) {
        sessionFactory.getCurrentSession().saveOrUpdate(categoriesdaoimpl);
 
    }

@SuppressWarnings("unchecked")
    public List<Categories> getAllCategories() {
 
        return sessionFactory.getCurrentSession().createQuery("from Categories")
                .list();
    }

    @Override
    public void deleteCategories(int categoriesdaoimplId) {
        Categories categoriesdaoimpl = (Categories) sessionFactory.getCurrentSession().load(
                Categories.class, categoriesdaoimplId);
        if (null != categoriesdaoimpl) {
            this.sessionFactory.getCurrentSession().delete(categoriesdaoimpl);
        }
 
    }



    public Categories getCategories(int categoriesdaoimplId) {
        return (Categories) sessionFactory.getCurrentSession().get(
                Categories.class, categoriesdaoimplId);
    }
    
    @Override
    public Categories findOrCreateRecord(String name) {
    	//String SQL_QUERY ="SELECT e.id, e.name, e.description, b.name AS brand, c.name AS category, e.created_at FROM Products AS e, Brands AS b, Categories AS c WHERE e.brand=b.brandId AND e.category=c.categoryId";
    	 String SQL_QUERY ="SELECT b FROM Categories AS b  WHERE b.name LIKE :name ";
		 Query query = sessionFactory.getCurrentSession().createQuery(SQL_QUERY);
		 query.setParameter("name", name);
		 Categories record = (Categories)query.uniqueResult();
		 if(record==null){
			 Categories b=new Categories(); b.setName(name); b.setActive(true);
			 addCategories(b);
			 String idx=getLastGeneratedId();
			 record =getCategories(Integer.parseInt(idx));
         }
    	
        return record;
    }

    @Override
    public Categories updateCategories(Categories categoriesdaoimpl) {
        sessionFactory.getCurrentSession().update(categoriesdaoimpl);
        return categoriesdaoimpl;
    }



	public String getLastGeneratedId(){
		//String lastId = ((String) sessionFactory.getCurrentSession().createSQLQuery("SELECT LAST_INSERT_ID()").uniqueResult()).toString();
		String lastId =""+ ((BigInteger) sessionFactory.getCurrentSession().createSQLQuery("SELECT LAST_INSERT_ID()").uniqueResult()).longValue();
		return lastId;
	}


}

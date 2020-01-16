package com.csoftware.apiassessment.dao.impl;

import java.math.BigInteger;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.csoftware.apiassessment.model.Categories;
import com.csoftware.apiassessment.model.Tags;
import com.csoftware.apiassessment.dao.TagsDAO;



@Repository
public class TagsDAOImpl implements TagsDAO {

    @Autowired
    private SessionFactory sessionFactory;

public void addTags(Tags tagsdaoimpl) {
        sessionFactory.getCurrentSession().saveOrUpdate(tagsdaoimpl);
 
    }

@SuppressWarnings("unchecked")
    public List<Tags> getAllTags() {
 
        return sessionFactory.getCurrentSession().createQuery("from Tags")
                .list();
    }

	@SuppressWarnings("unchecked")
	public List<Tags> getProductTags(long product) {
		 String SQL_QUERY ="SELECT e from Tags e, Taggedproducts t WHERE t.tag=e.tagId AND t.product=:id";
		 //String SQL_QUERY ="SELECT e from Tags e where e.product=:id";
		 Query query = sessionFactory.getCurrentSession().createQuery(SQL_QUERY);
		 query.setParameter("id", product);
	
	    //return sessionFactory.getCurrentSession().createQuery("from Tags").list();
		 return query.list();
	    
	}

 


    @Override
    public void deleteTags(int tagsdaoimplId) {
        Tags tagsdaoimpl = (Tags) sessionFactory.getCurrentSession().load(
                Tags.class, tagsdaoimplId);
        if (null != tagsdaoimpl) {
            this.sessionFactory.getCurrentSession().delete(tagsdaoimpl);
        }
 
    }



    public Tags getTags(int tagsdaoimplId) {
        return (Tags) sessionFactory.getCurrentSession().get(
                Tags.class, tagsdaoimplId);
    }
    
    @Override
    public Tags findOrCreateRecord(String name) { 
    	 String SQL_QUERY ="SELECT b FROM Tags AS b  WHERE b.name LIKE :name ";
		 Query query = sessionFactory.getCurrentSession().createQuery(SQL_QUERY);
		 query.setParameter("name", name);
		 Tags record = (Tags)query.uniqueResult();
		 if(record==null){
			 Tags b=new Tags(); b.setName(name); b.setActive(true);
			 addTags(b);
			 String idx=getLastGeneratedId();
			 record =getTags(Integer.parseInt(idx));
         }
    	
        return record;
    }

    @Override
    public Tags updateTags(Tags tagsdaoimpl) {
        sessionFactory.getCurrentSession().update(tagsdaoimpl);
        return tagsdaoimpl;
    }



	public String getLastGeneratedId(){
		//String lastId = ((String) sessionFactory.getCurrentSession().createSQLQuery("SELECT LAST_INSERT_ID()").uniqueResult()).toString();
		String lastId =""+ ((BigInteger) sessionFactory.getCurrentSession().createSQLQuery("SELECT LAST_INSERT_ID()").uniqueResult()).longValue();
		return lastId;
	}


}
